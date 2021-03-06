package pyroduck.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.Message;
import pyroduck.input.*;

public class GamePanel extends JPanel implements Observer {

    private final Game game;
    private final JLabel livesLabel = new JLabel();
    private JLabel pointsLabel = new JLabel();
    private JLabel messageLabel = new JLabel();
    private JLabel spaceLabel = new JLabel();
    private JButton musicButton = new JButton();
    private JButton skipDemo = new JButton();
    private final JButton startReturn = new JButton();
    private final JPanel panel = new JPanel();
    private final JPanel tutorialpanel = new JPanel();
    private Frame frame;
    private final Message message;
    private JFrame endGame;
    private final JLabel tutorial = new JLabel();

    public GamePanel(Frame frame) throws IOException {
        this.frame = frame;
        endGame = null;
        message = new Message(this);
        game = Game.getInstance();
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 420, Toolkit.getDefaultToolkit().getScreenSize().height - 100));
        add(game);
        setPanel();
        setTutorialPanel();
        game.setVisible(true);
        if (Board.getInstance().getLevel() <= 0) {
            skipDemo.setVisible(true);
            startReturn.setVisible(false);
        }
        skipDemo.addActionListener(new skip());
        panel.setBackground(Color.black);
        panel.add(livesLabel, 0);
        panel.add(messageLabel, 1);
        panel.add(pointsLabel, 2);
        panel.add(spaceLabel, 3);
        panel.add(musicButton, 4);
        panel.add(skipDemo, 5);
        panel.add(startReturn, 6);
        Board.getInstance().addObserver(this);
        this.add(panel, BorderLayout.PAGE_START);
        if(Game.getInstance().getDemo())
            this.add(tutorialpanel, BorderLayout.PAGE_END);
        setVisible(true);
        setFocusable(true);
    }

    private class setMusic implements ActionListener {

        boolean music;

        @Override
        public void actionPerformed(ActionEvent e) {
            //Estraiamo il pulsante che ha generato l'evento
            music = Game.getInstance().getMusicOn();
            try {
                Game.getInstance().setMusicOn(!music);
                game.requestFocus();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            JButton button = (JButton) e.getSource();
            if (!music) {
                try {
                    InputStream imgStream = getClass().getResourceAsStream("sound_32.png");
                    BufferedImage myImg = ImageIO.read(imgStream);
                    musicButton.setIcon(new javax.swing.ImageIcon(myImg));
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    InputStream imgStream = getClass().getResourceAsStream("notsound_32.png");
                    BufferedImage myImg = ImageIO.read(imgStream);
                    musicButton.setIcon(new javax.swing.ImageIcon(myImg));
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private class skip implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Board.getInstance().resetPoints();
            Game.getInstance().setDemo(false);
            pointsLabel.setText("Points: 0");
            Game.getInstance().resetProperties();
            Board.getInstance().changeLevel(1);
            tutorialpanel.setVisible(false);
            skipDemo.setVisible(false);
            startReturn.setVisible(true);
            game.requestFocus();
        }
    }

    private class returnToStart implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Board.getInstance().resetPoints();
            pointsLabel.setText("Points: 0");
            Game.getInstance().pause();
            Board.getInstance().restartLevel();
            Board.getInstance().getPlayer().remove();
            Keyboard.getInstance().releaseAll();
            setVisible(false);
            frame.setVisible(false);
            frame = null;
            StartGame s;
            try {
                s = new StartGame();
                s.setSize(1130, 600);
            s.setLocationRelativeTo(null);
            s.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Board.setBoard();
            Game.setGame();
            Game.getInstance().resetProperties();
        }
    }


    public  Game getGame() {
        return game;
    }

    @Override
    public void update(Observable o, Object arg) {
        livesLabel.setText("Lives: " + Board.getInstance().getLives());
        pointsLabel.setText("Points: " + Board.getInstance().getPoints());
        if(Board.getInstance().isFinish()){
            game.activeTimerEnd(frame);
            
        }
        if (Board.getInstance().getLives() <= 0) {
            if (endGame == null) 
                game.activeTimerEnd(frame);    //this set a boolean in game that active the ending of the game (temporized)
        } else {
            endGame = null;
            if(frame != null)
            frame.setVisible(true);
        }
        if (Board.getInstance().isPause() == true) {
            messageLabel.setForeground(Color.white);
            livesLabel.setForeground(Color.GRAY);
            pointsLabel.setForeground(Color.GRAY);
        }
        if (Board.getInstance().isPause() == false) {
            messageLabel.setForeground(Color.black);
            livesLabel.setForeground(Color.white);
            pointsLabel.setForeground(Color.white);
        }
        if (!Game.getInstance().getDemo() && Board.getInstance().getLevel() == 1 && !Board.getInstance().isPause() && tutorialpanel.isVisible()){
            skipDemo.setVisible(false);
            tutorialpanel.setVisible(false);
            startReturn.setVisible(true);
        }
    }

    private void setTutorialPanel(){
        tutorialpanel.setBackground(Color.black);
        tutorial.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        tutorial.setText("Press UP, DOWN, RIGHT, LEFT or W, S, D, A to move the player through the arena.");
        tutorial.setForeground(Color.white);
        tutorialpanel.add(tutorial, 0);
    }

    private void setPanel(){
        boolean music = game.getMusicOn();
        Font font = new Font(Font.DIALOG, Font.BOLD, 20);
        messageLabel = new JLabel("     Paused     ");
        spaceLabel = new JLabel("                         ");
        musicButton = new JButton("");
        livesLabel.setText("Lives: " + Board.getInstance().getLives());
        pointsLabel = new JLabel("Points: " + Board.getInstance().getPoints());
        messageLabel.setFont(font);
        pointsLabel.setForeground(Color.WHITE);
        livesLabel.setForeground(Color.WHITE);
        messageLabel.setForeground(Color.black);
        if (music){
            try {
                InputStream imgStream = getClass().getResourceAsStream("sound_32.png");
                BufferedImage myImg = ImageIO.read(imgStream);
                musicButton.setIcon(new javax.swing.ImageIcon(myImg));
            } catch (IOException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                InputStream imgStream = getClass().getResourceAsStream("notsound_32.png");
                BufferedImage myImg = ImageIO.read(imgStream);
                musicButton.setIcon(new javax.swing.ImageIcon(myImg));
            } catch (IOException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        musicButton.setForeground(Color.white);
        musicButton.addActionListener(new setMusic());
        startReturn.addActionListener(new returnToStart());
        startReturn.setText(" Return to Start ");
        skipDemo = new JButton(" Skip Demo ");
        skipDemo.setFont(font);
        startReturn.setFont(font);
        skipDemo.setForeground(Color.BLACK);
        skipDemo.setVisible(false);
    }

    public JLabel getTutorial(){
        return tutorial;
    }
}
