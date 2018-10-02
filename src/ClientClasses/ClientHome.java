
package ClientClasses;

import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;

public class ClientHome extends javax.swing.JFrame {

    private String ip;
    private javax.swing.JLabel background;
    private Image scaledInstance;
    public ClientHome() {
        setLayout(new BorderLayout());
         
        try {
          scaledInstance = ImageIO.read(new File("C:\\Users\\Hardeep\\Desktop\\vod main pics\\Resources\\5940.jpg"))
                                            .getScaledInstance(473,330, Image.SCALE_SMOOTH);  
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        background = new javax.swing.JLabel(new ImageIcon(scaledInstance));
        setContentPane(background);
        setLayout(new FlowLayout());
        repaint();
        initComponents();
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        lbWelcome = new javax.swing.JLabel();
        lbMAil = new javax.swing.JLabel();
        lbpass = new javax.swing.JLabel();
        btSignup = new javax.swing.JButton();
        btLogin1 = new javax.swing.JButton();
        lbForgotPassword = new javax.swing.JLabel();
        tfMail = new javax.swing.JTextField();
        pfPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        tfIp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Video Terminal");
        setResizable(false);

        lbWelcome.setBackground(new java.awt.Color(255, 255, 255));
        lbWelcome.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lbWelcome.setForeground(new java.awt.Color(255, 0, 51));
        lbWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbWelcome.setText("WELCOME");
        lbWelcome.setOpaque(true);

        lbMAil.setBackground(new java.awt.Color(255, 255, 255));
        lbMAil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbMAil.setForeground(new java.awt.Color(255, 255, 51));
        lbMAil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/email.png"))); // NOI18N
        lbMAil.setText("EMAIL");

        lbpass.setBackground(new java.awt.Color(255, 255, 255));
        lbpass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbpass.setForeground(new java.awt.Color(0, 204, 0));
        lbpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/see.png"))); // NOI18N
        lbpass.setToolTipText("Show Password");
        lbpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbpassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbpassMouseExited(evt);
            }
        });

        btSignup.setBackground(new java.awt.Color(255, 255, 255));
        btSignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/signup.png"))); // NOI18N
        btSignup.setText("SIGN UP");
        btSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignupActionPerformed(evt);
            }
        });

        btLogin1.setBackground(new java.awt.Color(255, 255, 255));
        btLogin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/signin.png"))); // NOI18N
        btLogin1.setText("LOG IN");
        btLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogin1ActionPerformed(evt);
            }
        });

        lbForgotPassword.setBackground(new java.awt.Color(255, 255, 255));
        lbForgotPassword.setForeground(new java.awt.Color(255, 255, 51));
        lbForgotPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbForgotPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/forgot.png"))); // NOI18N
        lbForgotPassword.setText("Forgotten Password");
        lbForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbForgotPasswordMouseClicked(evt);
            }
        });

        tfMail.setText("xyz@xyz.com");

        pfPass.setText("00000");
        pfPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pfPassKeyPressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 204, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("Video Terminal's Address");

        tfIp.setText("localhost");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/password.png"))); // NOI18N
        jLabel2.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfMail)
                            .addComponent(tfIp, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbpass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbForgotPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btLogin1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMAil, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMAil, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pfPass)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(lbForgotPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean processSignin(String ip,String email,String pass){
        return true;
    }
    
     //---Validate the input
    private boolean validateInput(String email, String pass) {
        if (email.isEmpty() ||pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields");
            return false;
        }
        return true;
    }
    
     private void requestLogin(String email,String pass) {
         String inp;
         if(email.equals("xyz@xyz.com") || pass.equals("0000")){
             new ClientClasses.VODMainFrame(ip).setVisible(true);
             dispose();
             JOptionPane.showMessageDialog(rootPane,"Download option will be unavailable for new users");
             
         }else{
         Socket socket = null;
          try {
            socket = new Socket(ip, 4000);
            DataOutputStream serverOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream serverInp = new DataInputStream(socket.getInputStream());
            serverOut.writeBytes("**LOGIN**\r\n");
            serverOut.writeBytes(email + "\r\n");
            serverOut.writeBytes(pass+ "\r\n");
            if((inp=serverInp.readLine()).equals("fail")){
                JOptionPane.showMessageDialog(rootPane,"Wrong Password or Email.");
            }else{
                new ClientClasses.VODMainFrame(ip,Integer.parseInt(inp)).setVisible(true);
                scaledInstance.flush();
                dispose();
            }
          }catch(IOException ioEx){
              if(socket == null){
                  JOptionPane.showMessageDialog(rootPane,"Video-Terminal Server not found at "+ip);
              }
              ioEx.printStackTrace();
          }finally{
              try {
                  socket.close();
              } catch (Exception e) {
                  //--
              }
          }
         }
          //return -1;
    }
     
    private void btLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogin1ActionPerformed
        String email = tfMail.getText();
        String pass  = new String(pfPass.getPassword());
        String ip    = tfIp.getText();
        String inp;
        if(validateInput(email,pass)){
           requestLogin(email,pass);
        }
        
    }//GEN-LAST:event_btLogin1ActionPerformed

    private void btSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSignupActionPerformed
          new ClientClasses.ClienSignUp(this.tfIp.getText()).setVisible(true);
          scaledInstance.flush();
          dispose();
    }//GEN-LAST:event_btSignupActionPerformed

    private void lbForgotPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbForgotPasswordMouseClicked
        String email = tfMail.getText(); 
        String received = null;
        System.out.println("clicked");
         if(email.isEmpty()){
              JOptionPane.showMessageDialog(rootPane,"Email is required for this operation.");
          }else{
              Socket socket = null;
              DataOutputStream serverOut = null;
              DataInputStream serverInp = null;
              try {
                socket = new Socket(ip, 4000);
                serverOut = new DataOutputStream(socket.getOutputStream());
                serverInp = new DataInputStream(socket.getInputStream());
                serverOut.writeBytes("**FIND**\r\n");
                serverOut.writeUTF(email);
                received=serverInp.readLine();
               //   System.out.println(received);
                
                if(received.equals("fail")){
                    JOptionPane.showMessageDialog(rootPane,"Email provided is not in our record.");
                } else{
                    System.out.println("New Frame");
                    new ClientClasses.ForgottenPassword(tfMail.getText(),tfIp.getText(),received).setVisible(true);
                    scaledInstance.flush();
                    dispose();
                    socket.close();
                }
               }catch (Exception e) {
                   //--
              }finally{
                  try {
                      if(!socket.isClosed()){
                          socket.close();
                      }
                  } catch (Exception e) {
                  }
              }
              
          }
    }//GEN-LAST:event_lbForgotPasswordMouseClicked

    private void pfPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfPassKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String email = tfMail.getText();
            String pass  = new String(pfPass.getPassword());
            if(validateInput(email,pass)){
                requestLogin(email,pass);
            }
        }
    }//GEN-LAST:event_pfPassKeyPressed

    private void lbpassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbpassMouseEntered
        this.pfPass.setEchoChar((char)0);
    }//GEN-LAST:event_lbpassMouseEntered

    private void lbpassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbpassMouseExited
        this.pfPass.setEchoChar('*');
    }//GEN-LAST:event_lbpassMouseExited

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
            java.util.logging.Logger.getLogger(ClientHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin1;
    private javax.swing.JButton btSignup;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lbForgotPassword;
    private javax.swing.JLabel lbMAil;
    private javax.swing.JLabel lbWelcome;
    private javax.swing.JLabel lbpass;
    private javax.swing.JPasswordField pfPass;
    private javax.swing.JTextField tfIp;
    private javax.swing.JTextField tfMail;
    // End of variables declaration//GEN-END:variables

   
}
