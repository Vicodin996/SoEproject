package pyroduck.gui;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Montefusco
 */
public class PowerupWindow extends javax.swing.JFrame {

    private final StartGame start;
    /**
     * Creates new form PowerupWindow
     */
    public PowerupWindow(StartGame start) {
        this.start = start;
        try {
            initComponents();       
            InputStream imgStream = getClass().getResourceAsStream("flame.png");
            BufferedImage myImg = ImageIO.read(imgStream);
            flameLabel.setIcon(new javax.swing.ImageIcon(myImg));
            imgStream = getClass().getResourceAsStream("bomb.png");
            myImg = ImageIO.read(imgStream);
            bombLabel.setIcon(new javax.swing.ImageIcon(myImg));
            imgStream = getClass().getResourceAsStream("inversion.png");
            myImg = ImageIO.read(imgStream);
            inversionLabel.setIcon(new javax.swing.ImageIcon(myImg));
            imgStream = getClass().getResourceAsStream("speed.png");
            myImg = ImageIO.read(imgStream);
            speedLabel.setIcon(new javax.swing.ImageIcon(myImg));
            imgStream = getClass().getResourceAsStream("live.png");
            myImg = ImageIO.read(imgStream);
            lifeLabel.setIcon(new javax.swing.ImageIcon(myImg));
            imgStream = getClass().getResourceAsStream("articuno.png");
            myImg = ImageIO.read(imgStream);
            articunoLabel.setIcon(new javax.swing.ImageIcon(myImg));
            imgStream = getClass().getResourceAsStream("brick.png");
            myImg = ImageIO.read(imgStream);
            brickLabel.setIcon(new javax.swing.ImageIcon(myImg));
            imgStream = getClass().getResourceAsStream("slide.png");
            myImg = ImageIO.read(imgStream);
            slideLabel.setIcon(new javax.swing.ImageIcon(myImg));
            imgStream = getClass().getResourceAsStream("exit_32.png");
            myImg = ImageIO.read(imgStream);
            exitLabel.setIcon(new javax.swing.ImageIcon(myImg));
            setLocationRelativeTo(null);
            setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(PowerupWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        lifeLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        inversionLabel = new javax.swing.JLabel();
        speedLabel = new javax.swing.JLabel();
        bombLabel = new javax.swing.JLabel();
        flameLabel = new javax.swing.JLabel();
        exitLabel = new javax.swing.JLabel();
        articunoLabel = new javax.swing.JLabel();
        brickLabel = new javax.swing.JLabel();
        slideLabel = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea9 = new javax.swing.JTextArea();

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Powerup");
        setBackground(new java.awt.Color(0, 204, 204));
        setMaximumSize(new java.awt.Dimension(650, 500));
        setMinimumSize(new java.awt.Dimension(650, 500));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(650, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(650, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea7.setEditable(false);
        jTextArea7.setBackground(new java.awt.Color(0, 153, 153));
        jTextArea7.setColumns(20);
        jTextArea7.setFont(new java.awt.Font("Comic Sans MS", 1, 15)); // NOI18N
        jTextArea7.setRows(5);
        jTextArea7.setText("It allows the \nyellow player to \nnot slide on ice.");
        jTextArea7.setBorder(null);
        jTextArea7.setFocusable(false);
        jScrollPane8.setViewportView(jTextArea7);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 137, 90));

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea5.setEditable(false);
        jTextArea5.setBackground(new java.awt.Color(0, 153, 153));
        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Comic Sans MS", 1, 15)); // NOI18N
        jTextArea5.setRows(5);
        jTextArea5.setText("It allows the \nplayer to become \na SuperPlayer and \nit lasts 10 \nseconds. ");
        jTextArea5.setBorder(null);
        jTextArea5.setFocusable(false);
        jScrollPane6.setViewportView(jTextArea5);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 137, 110));

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea8.setEditable(false);
        jTextArea8.setBackground(new java.awt.Color(0, 153, 153));
        jTextArea8.setColumns(20);
        jTextArea8.setFont(new java.awt.Font("Comic Sans MS", 1, 15)); // NOI18N
        jTextArea8.setRows(5);
        jTextArea8.setText("It increases the\nthe player life.");
        jTextArea8.setBorder(null);
        jTextArea8.setFocusable(false);
        jScrollPane9.setViewportView(jTextArea8);

        jPanel1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 137, 90));

        lifeLabel.setBackground(new java.awt.Color(255, 0, 153));
        lifeLabel.setText("life");
        lifeLabel.setMaximumSize(new java.awt.Dimension(90, 90));
        lifeLabel.setMinimumSize(new java.awt.Dimension(90, 90));
        lifeLabel.setPreferredSize(new java.awt.Dimension(90, 90));
        jPanel1.add(lifeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(0, 153, 153));
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Comic Sans MS", 1, 15)); // NOI18N
        jTextArea4.setRows(5);
        jTextArea4.setText("It inverts the \ncommands on the\nkeyboard.");
        jTextArea4.setBorder(null);
        jTextArea4.setFocusable(false);
        jScrollPane5.setViewportView(jTextArea4);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 137, 90));

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea6.setEditable(false);
        jTextArea6.setBackground(new java.awt.Color(0, 153, 153));
        jTextArea6.setColumns(20);
        jTextArea6.setFont(new java.awt.Font("Comic Sans MS", 1, 15)); // NOI18N
        jTextArea6.setRows(5);
        jTextArea6.setText("It increases the\nplayer speed.");
        jTextArea6.setBorder(null);
        jTextArea6.setFocusable(false);
        jScrollPane7.setViewportView(jTextArea6);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 137, 91));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 153, 153));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Comic Sans MS", 1, 15)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("It increases by \n1 the bombs you\ncan place.");
        jTextArea1.setBorder(null);
        jTextArea1.setFocusable(false);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 137, 90));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(0, 153, 153));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Comic Sans MS", 1, 15)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setText("It increases the\nradius of the \nbomb.");
        jTextArea3.setBorder(null);
        jTextArea3.setFocusable(false);
        jTextArea3.setMaximumSize(new java.awt.Dimension(90, 2147483647));
        jTextArea3.setMinimumSize(new java.awt.Dimension(90, 70));
        jScrollPane4.setViewportView(jTextArea3);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 137, 88));

        inversionLabel.setBackground(new java.awt.Color(153, 0, 0));
        inversionLabel.setText("inversion");
        inversionLabel.setMaximumSize(new java.awt.Dimension(90, 90));
        inversionLabel.setMinimumSize(new java.awt.Dimension(90, 90));
        inversionLabel.setPreferredSize(new java.awt.Dimension(90, 90));
        jPanel1.add(inversionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        speedLabel.setText("speed");
        speedLabel.setMaximumSize(new java.awt.Dimension(90, 90));
        speedLabel.setMinimumSize(new java.awt.Dimension(90, 90));
        speedLabel.setPreferredSize(new java.awt.Dimension(90, 90));
        jPanel1.add(speedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        bombLabel.setText("bomb");
        bombLabel.setMaximumSize(new java.awt.Dimension(90, 90));
        bombLabel.setMinimumSize(new java.awt.Dimension(90, 90));
        bombLabel.setPreferredSize(new java.awt.Dimension(90, 90));
        jPanel1.add(bombLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        flameLabel.setBackground(new java.awt.Color(255, 153, 102));
        flameLabel.setText("flame");
        flameLabel.setMaximumSize(new java.awt.Dimension(90, 90));
        flameLabel.setMinimumSize(new java.awt.Dimension(90, 90));
        flameLabel.setPreferredSize(new java.awt.Dimension(90, 90));
        jPanel1.add(flameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 88));

        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabelMouseClicked(evt);
            }
        });
        jPanel1.add(exitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 40, 40));

        articunoLabel.setText("articuno");
        articunoLabel.setMaximumSize(new java.awt.Dimension(90, 90));
        articunoLabel.setMinimumSize(new java.awt.Dimension(90, 90));
        articunoLabel.setPreferredSize(new java.awt.Dimension(90, 90));
        jPanel1.add(articunoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 90, 90));

        brickLabel.setText("brick");
        brickLabel.setMaximumSize(new java.awt.Dimension(90, 90));
        brickLabel.setMinimumSize(new java.awt.Dimension(90, 90));
        brickLabel.setPreferredSize(new java.awt.Dimension(90, 90));
        jPanel1.add(brickLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 90, 90));

        slideLabel.setText("slide");
        slideLabel.setMaximumSize(new java.awt.Dimension(90, 90));
        slideLabel.setMinimumSize(new java.awt.Dimension(90, 90));
        slideLabel.setPreferredSize(new java.awt.Dimension(90, 90));
        jPanel1.add(slideLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 100, 90));

        jScrollPane10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane10.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea9.setEditable(false);
        jTextArea9.setBackground(new java.awt.Color(0, 153, 153));
        jTextArea9.setColumns(20);
        jTextArea9.setFont(new java.awt.Font("Comic Sans MS", 1, 15)); // NOI18N
        jTextArea9.setRows(5);
        jTextArea9.setText("It decreases the\nplayer speed.\nBut, it is hidden \nin the game.");
        jTextArea9.setBorder(null);
        jTextArea9.setFocusable(false);
        jScrollPane10.setViewportView(jTextArea9);

        jPanel1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 137, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked
        start.setEnabled(true);
        dispose();
    }//GEN-LAST:event_exitLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel articunoLabel;
    private javax.swing.JLabel bombLabel;
    private javax.swing.JLabel brickLabel;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JLabel flameLabel;
    private javax.swing.JLabel inversionLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JLabel lifeLabel;
    private javax.swing.JLabel slideLabel;
    private javax.swing.JLabel speedLabel;
    // End of variables declaration//GEN-END:variables
}
