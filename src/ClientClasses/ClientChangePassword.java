
package ClientClasses;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class ClientChangePassword extends javax.swing.JFrame {
 
    String user_id;
    String ip;
    private String email;
    private String pass;
    private DataOutputStream serverOut;
    private DataInputStream serverInp;
    private Socket socket;
    private int cbIndex = 0;
    private javax.swing.JLabel background;
    private Image scaledInstance1 = null;
    public ClientChangePassword(String user_id,String ip) {
        setLayout(new BorderLayout());
        
        try {
          scaledInstance1 = ImageIO.read(new File("C:\\Users\\Hardeep\\Desktop\\vod main pics\\Resources\\5940.jpg"))
                                            .getScaledInstance(568,438, Image.SCALE_SMOOTH);  
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        background = new javax.swing.JLabel(new ImageIcon(scaledInstance1));
        setContentPane(background);
        setLayout(new FlowLayout());
        repaint();
        initComponents();
        StringTokenizer str = new StringTokenizer(user_id,",");
        this.user_id = str.nextToken();//0
        this.user_id = str.nextToken();//user_id
        System.out.println(user_id);
        this.ip = ip;
        try{
            socket = new Socket(ip,4000);
            serverInp = new DataInputStream(socket.getInputStream());
            serverOut = new DataOutputStream(socket.getOutputStream());
            serverOut.writeBytes("senduser\r\n");
            serverOut.writeBytes(this.user_id+"\r\n");
            email = serverInp.readLine();
            pass = serverInp.readLine();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        this.tfMail.setText(email);
        this.tfMail.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbMAin = new javax.swing.JLabel();
        tfMail = new javax.swing.JTextField();
        btClearAll = new javax.swing.JButton();
        lbMail = new javax.swing.JLabel();
        btSubmit = new javax.swing.JButton();
        lbNPass = new javax.swing.JLabel();
        lbCPass = new javax.swing.JLabel();
        pfNPass = new javax.swing.JPasswordField();
        pfCPass = new javax.swing.JPasswordField();
        lbNPass1 = new javax.swing.JLabel();
        lbNPass2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Video-Terminal : Change Password");
        setResizable(false);

        lbMAin.setBackground(new java.awt.Color(255, 255, 255));
        lbMAin.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lbMAin.setForeground(new java.awt.Color(255, 0, 0));
        lbMAin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMAin.setText("Change Password");
        lbMAin.setOpaque(true);

        tfMail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btClearAll.setBackground(new java.awt.Color(255, 255, 255));
        btClearAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/broom.png"))); // NOI18N
        btClearAll.setText("CLEAR ALL");
        btClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearAllActionPerformed(evt);
            }
        });

        lbMail.setBackground(new java.awt.Color(255, 255, 255));
        lbMail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbMail.setForeground(new java.awt.Color(255, 255, 51));
        lbMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/email.png"))); // NOI18N
        lbMail.setText(" EMAIL");
        lbMail.setToolTipText("EMAIL");

        btSubmit.setBackground(new java.awt.Color(255, 255, 255));
        btSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/signin.png"))); // NOI18N
        btSubmit.setText("SUBMIT");
        btSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubmitActionPerformed(evt);
            }
        });

        lbNPass.setBackground(new java.awt.Color(255, 255, 255));
        lbNPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNPass.setForeground(new java.awt.Color(255, 255, 51));
        lbNPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/password.png"))); // NOI18N
        lbNPass.setText("New Password");

        lbCPass.setBackground(new java.awt.Color(255, 255, 255));
        lbCPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCPass.setForeground(new java.awt.Color(255, 255, 51));
        lbCPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/password.png"))); // NOI18N
        lbCPass.setText("Confirm Password");

        pfCPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pfCPassKeyPressed(evt);
            }
        });

        lbNPass1.setBackground(new java.awt.Color(255, 255, 255));
        lbNPass1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNPass1.setForeground(new java.awt.Color(255, 255, 51));
        lbNPass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/see.png"))); // NOI18N
        lbNPass1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbNPass1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbNPass1MouseExited(evt);
            }
        });

        lbNPass2.setBackground(new java.awt.Color(255, 255, 255));
        lbNPass2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNPass2.setForeground(new java.awt.Color(255, 255, 51));
        lbNPass2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/see.png"))); // NOI18N
        lbNPass2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbNPass2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbNPass2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbMAin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbMail, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pfCPass, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbNPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfMail, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pfNPass, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbNPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(351, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbMAin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfMail, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNPass, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pfNPass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lbNPass2)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCPass, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfCPass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(btClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(364, Short.MAX_VALUE)
                    .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(25, 25, 25)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void clearAll() {
       pfCPass.setText("");
       pfNPass.setText("");
    }
    
    private boolean validateInput(String newPass,String conPass){
        if(newPass.isEmpty() || conPass.isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Please fill all fields.");
            return false;
        }else if(newPass.equals(this.pass)){
            JOptionPane.showMessageDialog(rootPane,"New Password cannot equal to Old Password.");
            return false;
        }else if(!newPass.equals(conPass)){
            JOptionPane.showMessageDialog(rootPane,"New Password and Confirm Password do not match.");
           return false;
        }
        return true;   
    }
   
    private void submitData(){
       String newPass = new String(pfNPass.getPassword());
       String conPass = new String(pfCPass.getPassword());
       if(validateInput(newPass,conPass)){
           try {
                serverOut.writeBytes("**CPASS**\r\n");
                serverOut.writeBytes(user_id+"\r\n");
                serverOut.writeBytes(newPass+"\r\n");
                serverOut.writeBytes(this.user_id+"\r\n");
                String res = serverInp.readLine();
                if(res.equals("succ")){
                    clearAll();
                    new ClientClasses.ClientHome().setVisible(true);
                    scaledInstance1.flush();
                    dispose();
                    JOptionPane.showMessageDialog(rootPane,"Password Successfuly Changed.");
                }else{
                    JOptionPane.showMessageDialog(rootPane,"Unable to Change Password.");
                }
                
           } catch (Exception e) {
           }
       }    
    }
    
    private void btClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearAllActionPerformed
        clearAll();
    }//GEN-LAST:event_btClearAllActionPerformed
   
    private void btSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubmitActionPerformed
         submitData();
    }//GEN-LAST:event_btSubmitActionPerformed

    private void lbNPass2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNPass2MouseEntered
        this.pfNPass.setEchoChar((char)0);
    }//GEN-LAST:event_lbNPass2MouseEntered

    private void lbNPass2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNPass2MouseExited
        this.pfNPass.setEchoChar('*');
    }//GEN-LAST:event_lbNPass2MouseExited

    private void lbNPass1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNPass1MouseEntered
        this.pfCPass.setEchoChar((char)0);
    }//GEN-LAST:event_lbNPass1MouseEntered

    private void lbNPass1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNPass1MouseExited
         this.pfCPass.setEchoChar('*');
    }//GEN-LAST:event_lbNPass1MouseExited

    private void pfCPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfCPassKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            submitData();
        }
    }//GEN-LAST:event_pfCPassKeyPressed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new ClientChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClearAll;
    private javax.swing.JButton btSubmit;
    private javax.swing.JLabel lbCPass;
    private javax.swing.JLabel lbMAin;
    private javax.swing.JLabel lbMail;
    private javax.swing.JLabel lbNPass;
    private javax.swing.JLabel lbNPass1;
    private javax.swing.JLabel lbNPass2;
    private javax.swing.JPasswordField pfCPass;
    private javax.swing.JPasswordField pfNPass;
    private javax.swing.JTextField tfMail;
    // End of variables declaration//GEN-END:variables

    
}
