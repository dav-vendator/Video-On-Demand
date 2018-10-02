package ClientClasses;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class MethodSecFrame extends javax.swing.JFrame {

    private String msg;
    private String ip;
    private Socket socket;
    private DataOutputStream serverOut;
    private DataInputStream serverInp;

    MethodSecFrame(String msg, String ip) {
        initComponents();
        this.msg = msg;
        try {
            socket = new Socket(ip, 4000);
            serverOut = new DataOutputStream(socket.getOutputStream());
            serverInp = new DataInputStream(socket.getInputStream());
            serverOut.writeBytes("**SEC**\r\n");
            System.out.println(msg);
            StringTokenizer str = new StringTokenizer(msg, ",");
            System.out.println("ddddd");
            String next = str.nextToken();
            //System.out.println();
            serverOut.writeBytes((msg = str.nextToken()) + "\r\n");
            this.lbQuestion.setText(serverInp.readLine());
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbMain = new javax.swing.JLabel();
        lbQuestion = new javax.swing.JLabel();
        tfAnswer = new javax.swing.JTextField();
        btSubmit = new javax.swing.JToggleButton();
        lbAnswer = new javax.swing.JLabel();
        lbExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Video-Termianal : Password Recovery");
        setResizable(false);

        lbMain.setBackground(new java.awt.Color(255, 255, 255));
        lbMain.setFont(new java.awt.Font("Times New Roman", 0, 34)); // NOI18N
        lbMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMain.setText("Password Recovery");

        lbQuestion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbQuestion.setText("Question");

        btSubmit.setText("Submit");
        btSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubmitActionPerformed(evt);
            }
        });

        lbAnswer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbAnswer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAnswer.setText("Answer :");

        lbExit.setText("Exit");
        lbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbMain, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
            .addComponent(lbQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lbAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbMain, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(lbExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubmitActionPerformed
        if (tfAnswer.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please fill all the fields.");
        } else {
            try {
                serverOut.writeBytes(tfAnswer.getText() + "\r\n");
                if (serverInp.readLine().equals("**succ**")) {
                    System.out.println("launching frae");
                    if(msg==null){
                        System.out.println("nulllllll");
                    }
                    new ClientClasses.ClientChangePassword(this.msg,ip).setVisible(true);
                    dispose();
                    try {
                        socket.close();
                    } catch (Exception e) {
                    }
                }
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        }
    }//GEN-LAST:event_btSubmitActionPerformed

    private void lbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_lbExitActionPerformed

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
            java.util.logging.Logger.getLogger(MethodSecFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MethodSecFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MethodSecFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MethodSecFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //  new MethodSecFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btSubmit;
    private javax.swing.JLabel lbAnswer;
    private javax.swing.JButton lbExit;
    private javax.swing.JLabel lbMain;
    private javax.swing.JLabel lbQuestion;
    private javax.swing.JTextField tfAnswer;
    // End of variables declaration//GEN-END:variables
}
