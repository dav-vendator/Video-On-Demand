
package ClientClasses;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


public class MethodOtpFrame extends javax.swing.JFrame {
    private String msg;
    private String ip;
    private Socket socket;
    private DataOutputStream serverOut;
    private DataInputStream serverInp;

    public MethodOtpFrame(String msg, String ip) {
        initComponents();
         this.msg = msg;
        try {
            socket = new Socket(ip, 4000);
            serverOut = new DataOutputStream(socket.getOutputStream());
            serverInp = new DataInputStream(socket.getInputStream());
            serverOut.writeBytes("**OTP**\r\n");
            StringTokenizer str = new StringTokenizer(msg, ",");
            String next = str.nextToken();
            //System.out.println();
            serverOut.writeBytes((msg = str.nextToken()) + "\r\n");
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfAnswer = new javax.swing.JTextField();
        btSubmit = new javax.swing.JButton();
        lbMain = new javax.swing.JLabel();
        lbExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Password Recovery");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Fill  Password Reset Code Here ");

        btSubmit.setBackground(new java.awt.Color(255, 255, 255));
        btSubmit.setText("SUBMIT");
        btSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubmitActionPerformed(evt);
            }
        });

        lbMain.setBackground(new java.awt.Color(255, 255, 255));
        lbMain.setFont(new java.awt.Font("Times New Roman", 0, 34)); // NOI18N
        lbMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMain.setText("Password Recovery");

        lbExit.setBackground(new java.awt.Color(255, 255, 255));
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(tfAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lbMain, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbMain, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbExitActionPerformed
       this.dispose();
    }//GEN-LAST:event_lbExitActionPerformed

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
            java.util.logging.Logger.getLogger(MethodOtpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MethodOtpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MethodOtpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MethodOtpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MethodOtpFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton lbExit;
    private javax.swing.JLabel lbMain;
    private javax.swing.JTextField tfAnswer;
    // End of variables declaration//GEN-END:variables
}
