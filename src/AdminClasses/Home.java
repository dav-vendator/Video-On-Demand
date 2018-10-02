package AdminClasses;


import java.awt.Dimension;
import java.sql.*;

public class Home extends javax.swing.JFrame {

    private String email;
    private Connection dbCon;
    private Thread serverThread;

    public Home(String email, Connection con) {
        serverThread = new Thread(new VODServer(4000));
        serverThread.start();
        this.email = email;
        this.dbCon = con;
        this.setSize(1000, 750);
        initComponents();
        this.jDesktopPane1.setSize(1000,750);
        this.validate();
        //this.setResizable(false);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        miView = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        miAddTvShow = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem6 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnChangePass = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADMIN\"S HOME");
        setMaximumSize(new java.awt.Dimension(1000, 750));
        getContentPane().setLayout(null);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(0, -1, 650, 370);

        jMenu5.setText("Manage Categories");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Add Category");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("View Catagory");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jCheckBoxMenuItem2);

        jMenuBar2.add(jMenu5);

        jMenu4.setText("Manage Videos");

        jMenuItem2.setText("Add Videos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        miView.setText("View Videos");
        miView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miViewActionPerformed(evt);
            }
        });
        jMenu4.add(miView);

        jMenuBar2.add(jMenu4);

        jMenu6.setText("Manage TV Shows");

        miAddTvShow.setSelected(true);
        miAddTvShow.setText("Add TV Shows");
        miAddTvShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddTvShowActionPerformed(evt);
            }
        });
        jMenu6.add(miAddTvShow);

        jCheckBoxMenuItem5.setSelected(true);
        jCheckBoxMenuItem5.setText("View TV Shows");
        jCheckBoxMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jCheckBoxMenuItem5);

        jCheckBoxMenuItem6.setSelected(true);
        jCheckBoxMenuItem6.setText("Add Episode");
        jCheckBoxMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jCheckBoxMenuItem6);

        jCheckBoxMenuItem4.setSelected(true);
        jCheckBoxMenuItem4.setText("View Episode");
        jCheckBoxMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jCheckBoxMenuItem4);

        jMenuBar2.add(jMenu6);

        jMenu3.setText("Others");

        mnChangePass.setText("Change Password");
        mnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnChangePassActionPerformed(evt);
            }
        });
        jMenu3.add(mnChangePass);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnChangePassActionPerformed
        ChangePassword cp = new ChangePassword(this.email, this.dbCon);
        cp.setSize(500, 300);
        cp.setIconifiable(true);
        cp.setMaximizable(true);
        cp.setClosable(true);
        cp.setResizable(false);
        this.jDesktopPane1.add(cp);
        cp.setVisible(true);
        cp.moveToFront();

    }//GEN-LAST:event_mnChangePassActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        AddCategories addCat = new AddCategories(this.email, this.dbCon);
        addCat.setSize(635, 369);
        addCat.setIconifiable(true);
        addCat.setMaximizable(true);
        addCat.setResizable(false);
        addCat.setClosable(true);
        this.jDesktopPane1.add(addCat);
        addCat.setVisible(true);
        addCat.moveToFront();
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        ViewCategory viewData = new ViewCategory(this.dbCon);
        viewData.setSize(537, 300);
        viewData.setIconifiable(true);
        viewData.setMaximizable(true);
        viewData.setResizable(false);
        viewData.setClosable(true);
        this.jDesktopPane1.add(viewData);
        viewData.setVisible(true);
        viewData.moveToFront();
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        AddVideo addVideo = new AddVideo(true,false);
        addVideo.setSize(880, 690);
        addVideo.setIconifiable(true);
        addVideo.setMaximizable(true);
        addVideo.setClosable(true);
        addVideo.setResizable(false);
        this.jDesktopPane1.add(addVideo);
        addVideo.setVisible(true);
        addVideo.moveToFront();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void miViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miViewActionPerformed

        ViewVideos viewVideo = new ViewVideos();
        viewVideo.setSize(653, 470);
        viewVideo.setIconifiable(true);
        viewVideo.setMaximizable(true);
        viewVideo.setClosable(true);
        viewVideo.setResizable(false);
        this.jDesktopPane1.add(viewVideo);
        viewVideo.setVisible(true);
        viewVideo.moveToFront();
    }//GEN-LAST:event_miViewActionPerformed

    private void miAddTvShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddTvShowActionPerformed

        AddVideo addVideo = new AddVideo(false,true);
        addVideo.setSize(850, 550);
        addVideo.setIconifiable(true);
        addVideo.setMaximizable(true);
        addVideo.setClosable(true);
        addVideo.setResizable(false);
        this.jDesktopPane1.add(addVideo);
        addVideo.setVisible(true);
        addVideo.moveToFront();

    }//GEN-LAST:event_miAddTvShowActionPerformed

    private void jCheckBoxMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem5ActionPerformed
        // TODO add your handling code here:
        ViewTvShow viewTv = new ViewTvShow();
        viewTv.setSize(700,570);
        viewTv.setIconifiable(true);
        viewTv.setMaximizable(true);
        viewTv.setClosable(true);
        viewTv.setResizable(false);
        this.jDesktopPane1.add(viewTv);
        viewTv.setVisible(true);
        viewTv.moveToFront();

    }//GEN-LAST:event_jCheckBoxMenuItem5ActionPerformed

    private void jCheckBoxMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem6ActionPerformed
        // TODO add your handling code here:
        AddEpisode addEpisode = new AddEpisode();
        addEpisode.setSize(800, 570);
        addEpisode.setIconifiable(true);
        addEpisode.setMaximizable(true);
        addEpisode.setClosable(true);
        addEpisode.setResizable(false);
        this.jDesktopPane1.add(addEpisode);
        addEpisode.setVisible(true);
        addEpisode.moveToFront();

    }//GEN-LAST:event_jCheckBoxMenuItem6ActionPerformed

    private void jCheckBoxMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem4ActionPerformed
        ViewEpisode viewEpisode = new ViewEpisode();
        viewEpisode.setSize(570, 480);
        viewEpisode.setIconifiable(true);
        viewEpisode.setMaximizable(true);
        viewEpisode.setClosable(true);
        viewEpisode.setResizable(false);
        this.jDesktopPane1.add(viewEpisode);
        viewEpisode.setVisible(true);
        viewEpisode.moveToFront();

    }//GEN-LAST:event_jCheckBoxMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Home("",null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem6;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JCheckBoxMenuItem miAddTvShow;
    private javax.swing.JMenuItem miView;
    private javax.swing.JMenuItem mnChangePass;
    // End of variables declaration//GEN-END:variables
}
