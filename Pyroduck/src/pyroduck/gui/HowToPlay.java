package pyroduck.gui;

import java.awt.Point;

/**
 *
 * @author 
 */
public class HowToPlay extends javax.swing.JFrame {

    /**
     * Creates new form HowToPlay
     */
    public HowToPlay() {
        initComponents();
        Point middle = new Point(600,200);
        setLocation(middle);
        exitLabel.setIcon (new javax.swing.ImageIcon(".\\resources\\textures\\SelectCharacter\\exit_32.png"));
        setVisible(true);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        exitLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(480, 370));
        setMinimumSize(new java.awt.Dimension(480, 370));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(510, 385));
        jPanel1.setMinimumSize(new java.awt.Dimension(510, 385));
        jPanel1.setPreferredSize(new java.awt.Dimension(510, 385));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Comic Sans MS", 0, 15)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("The goal of the game is to destroy the enemies, \npicking up powerup, and go through two different\nworlds.\nEach world is composed by two levels and different\nenemies.\nThe first world is \"The GrassArena\" and the second\none is \"The IceArena\".\nThe IceArena has some trouble, so... be careful\nwhen you chose the character!\nTo go through levels it is necessary defeat all the\nenemies to unlock the portal.\nThe portal will allow you to pass the level till the \nend.\n");
        jTextArea1.setMargin(new java.awt.Insets(4, 4, 4, 4));
        jTextArea1.setMaximumSize(new java.awt.Dimension(380, 325));
        jTextArea1.setMinimumSize(new java.awt.Dimension(380, 325));
        jTextArea1.setPreferredSize(new java.awt.Dimension(380, 325));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 390, 325));

        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabelMouseClicked(evt);
            }
        });
        jPanel1.add(exitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked
        dispose();
    }//GEN-LAST:event_exitLabelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
