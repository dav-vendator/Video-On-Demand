package ClientClasses;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ClienSignUp extends javax.swing.JFrame {
      
    private ArrayList<String> alSecQues;
    private int selectedQuestion = 0; //combo box
    private String ip;
    private JLabel background;
    public ClienSignUp(String ip) {
        setLayout(new BorderLayout());
        Image scaledInstance1 = null;
        try {
          scaledInstance1 = ImageIO.read(new File("C:\\Users\\Hardeep\\Desktop\\vod main pics\\Resources\\5940.jpg"))
                                            .getScaledInstance(639,512, Image.SCALE_SMOOTH);  
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        background = new javax.swing.JLabel(new ImageIcon(scaledInstance1));
        setContentPane(background);
        setLayout(new FlowLayout());
        this.ip = ip;
        alSecQues = new ArrayList<>();
        alSecQues.add("What is your Nick-Name?");
        alSecQues.add("What was your first pet's name?");
        alSecQues.add("How old were you,when you got your first ride?");
        alSecQues.add("What is your friend's pet-Name?");
        alSecQues.add("Which Company's mobile was your first mobile?");
        initComponents();
        this.jTextField1.setEnabled(false);
        this.setTitle("VOD : User Sign Up");
        this.setResizable(false);
        this.cbSecQues.addItem("Select a Security Question..");
        for (String s : alSecQues) {
            this.cbSecQues.addItem(s);
        }
        Socket testCon = null;
        try{
            testCon = new Socket(ip,4000);
        }catch(IOException ex){
            JOptionPane.showMessageDialog(rootPane,"Unable to connect with Video-Terminal's"
                    + "  Server Closing.....");
           //this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSED));
           System.exit(-1);
        }finally{
            if(!(testCon == null)){
                try {
                    this.jTextField1.setText("Server 's Status : Server is available at "+ip);
                   testCon.close();                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
              
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        lbMail = new javax.swing.JLabel();
        lbPass = new javax.swing.JLabel();
        lbConfirmPass = new javax.swing.JLabel();
        lbSecQues = new javax.swing.JLabel();
        lbSecAns = new javax.swing.JLabel();
        lbConatctNo = new javax.swing.JLabel();
        btSignup = new javax.swing.JButton();
        btClearall = new javax.swing.JButton();
        tfEmail = new javax.swing.JTextField();
        tfSecurityAns = new javax.swing.JTextField();
        pfPass = new javax.swing.JPasswordField();
        pfConfirm = new javax.swing.JPasswordField();
        cbSecQues = new javax.swing.JComboBox<>();
        tfContact = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        lbNPass2 = new javax.swing.JLabel();
        lbNPass3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Video Terminal User SignUp");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(644, 540));
        setResizable(false);
        getContentPane().setLayout(null);

        lbTitle.setBackground(new java.awt.Color(102, 0, 102));
        lbTitle.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(0, 204, 51));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("User SignUp");
        lbTitle.setOpaque(true);
        getContentPane().add(lbTitle);
        lbTitle.setBounds(0, 0, 640, 60);

        lbMail.setBackground(new java.awt.Color(255, 255, 255));
        lbMail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbMail.setForeground(new java.awt.Color(255, 255, 51));
        lbMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/email.png"))); // NOI18N
        lbMail.setText("Email");
        getContentPane().add(lbMail);
        lbMail.setBounds(20, 78, 110, 25);

        lbPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbPass.setForeground(new java.awt.Color(255, 255, 51));
        lbPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/password.png"))); // NOI18N
        lbPass.setText("Password");
        getContentPane().add(lbPass);
        lbPass.setBounds(20, 137, 110, 25);

        lbConfirmPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbConfirmPass.setForeground(new java.awt.Color(255, 255, 51));
        lbConfirmPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/password.png"))); // NOI18N
        lbConfirmPass.setText("Confirm Password");
        getContentPane().add(lbConfirmPass);
        lbConfirmPass.setBounds(20, 193, 138, 25);

        lbSecQues.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSecQues.setForeground(new java.awt.Color(255, 255, 51));
        lbSecQues.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/question.png"))); // NOI18N
        lbSecQues.setText("Security Question");
        getContentPane().add(lbSecQues);
        lbSecQues.setBounds(20, 250, 150, 25);

        lbSecAns.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSecAns.setForeground(new java.awt.Color(255, 255, 51));
        lbSecAns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/answer.png"))); // NOI18N
        lbSecAns.setText("Security Answer");
        getContentPane().add(lbSecAns);
        lbSecAns.setBounds(20, 308, 170, 25);

        lbConatctNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbConatctNo.setForeground(new java.awt.Color(255, 255, 51));
        lbConatctNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/phone-contact.png"))); // NOI18N
        lbConatctNo.setText("Conatct No.");
        getContentPane().add(lbConatctNo);
        lbConatctNo.setBounds(20, 368, 110, 24);

        btSignup.setBackground(new java.awt.Color(255, 255, 255));
        btSignup.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hardeep\\Desktop\\vod main pics\\Resources\\file-submit.png")); // NOI18N
        btSignup.setText("Sign Up");
        btSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignupActionPerformed(evt);
            }
        });
        getContentPane().add(btSignup);
        btSignup.setBounds(117, 422, 197, 34);

        btClearall.setBackground(new java.awt.Color(255, 255, 255));
        btClearall.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hardeep\\Desktop\\vod main pics\\Resources\\broom.png")); // NOI18N
        btClearall.setText("Clear All");
        btClearall.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btClearall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearallActionPerformed(evt);
            }
        });
        getContentPane().add(btClearall);
        btClearall.setBounds(390, 422, 160, 40);

        tfEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(tfEmail);
        tfEmail.setBounds(300, 77, 250, 30);

        tfSecurityAns.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(tfSecurityAns);
        tfSecurityAns.setBounds(300, 307, 250, 30);

        pfPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(pfPass);
        pfPass.setBounds(300, 139, 250, 30);

        pfConfirm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(pfConfirm);
        pfConfirm.setBounds(300, 195, 250, 30);

        cbSecQues.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbSecQues.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSecQuesItemStateChanged(evt);
            }
        });
        getContentPane().add(cbSecQues);
        cbSecQues.setBounds(300, 249, 290, 28);

        tfContact.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(tfContact);
        tfContact.setBounds(300, 367, 180, 30);

        jTextField1.setBackground(new java.awt.Color(255, 255, 51));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setText("Server 's Status : ");
        jTextField1.setEnabled(false);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(0, 480, 640, 30);

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
        getContentPane().add(lbNPass2);
        lbNPass2.setBounds(560, 200, 24, 24);

        lbNPass3.setBackground(new java.awt.Color(255, 255, 255));
        lbNPass3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNPass3.setForeground(new java.awt.Color(255, 255, 51));
        lbNPass3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientClasses/see.png"))); // NOI18N
        lbNPass3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbNPass3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbNPass3MouseExited(evt);
            }
        });
        getContentPane().add(lbNPass3);
        lbNPass3.setBounds(560, 140, 24, 24);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //--clears everything
    private void clearAllFields() {
        this.pfPass.setText("");
        this.pfConfirm.setText("");
        this.tfEmail.setText("");
        this.tfSecurityAns.setText("");
        this.tfContact.setText("");
        this.cbSecQues.setSelectedIndex(0);
        this.selectedQuestion = 0;
    }

    //---Send data
    private void sendData(String email, String password, String secQues, String secAns, String contactNum) {
        try {
            Socket socket = new Socket(ip, 4000);
            DataOutputStream serverOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream serverInp = new DataInputStream(socket.getInputStream());
            serverOut.writeBytes("**SIGNUP**\r\n");
            serverOut.writeBytes(email + "\r\n");
            serverOut.writeBytes(password + "\r\n");
            serverOut.writeBytes(secQues + "\r\n");
            serverOut.writeBytes(secAns + "\r\n");
            serverOut.writeBytes(contactNum + "\r\n");
            String inpu = serverInp.readLine();
            if (inpu.equals("success")) {
                JOptionPane.showMessageDialog(this, "Account with email: " + email + " added successfuly.");
                ClientHome clh = new ClientHome();
                clh.setVisible(true);
                clearAllFields();
                dispose();
            } else if (inpu.equals("fail")) {
                JOptionPane.showMessageDialog(this, "Account with email: " + email + " already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //---Validate the input
    private boolean validateInput(String email, String secAns, String contactNum, String password, String confPassword) {
        if (email.isEmpty() || secAns.isEmpty() || contactNum.isEmpty()
                || password.isEmpty() || confPassword.isEmpty() || selectedQuestion == 0) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields");
            return false;
        }

        try {
            Integer.parseInt(contactNum.substring(1, contactNum.length()));
            if (contactNum.charAt(0) != '+' && !Character.isDigit(contactNum.charAt(0))) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid information in contact field");
            return false;
        }
        //---Checking if both passwords are equal
        if (!(password.equals(confPassword))) {
            JOptionPane.showMessageDialog(this, "Password and Confirm Password do not match");
            return false;
        }
        return true;
    }

    private void btSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSignupActionPerformed
        String email = tfEmail.getText();
        String secAns = tfSecurityAns.getText();
        String contactNum = tfContact.getText();
        String password = new String(pfPass.getPassword());
        String confPassword = new String(pfConfirm.getPassword());
        if (validateInput(email, secAns, contactNum, password, confPassword)) {
            sendData(email, password, alSecQues.get(selectedQuestion - 1), secAns, contactNum);
        }
    }//GEN-LAST:event_btSignupActionPerformed

    private void btClearallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearallActionPerformed
        clearAllFields();
    }//GEN-LAST:event_btClearallActionPerformed

    private void cbSecQuesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSecQuesItemStateChanged
        this.selectedQuestion = this.cbSecQues.getSelectedIndex();
    }//GEN-LAST:event_cbSecQuesItemStateChanged

    private void lbNPass2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNPass2MouseEntered
        this.pfConfirm.setEchoChar((char)0);
    }//GEN-LAST:event_lbNPass2MouseEntered

    private void lbNPass2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNPass2MouseExited
        this.pfConfirm.setEchoChar('*');
    }//GEN-LAST:event_lbNPass2MouseExited

    private void lbNPass3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNPass3MouseEntered
        this.pfPass.setEchoChar((char)0);
    }//GEN-LAST:event_lbNPass3MouseEntered

    private void lbNPass3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNPass3MouseExited
        this.pfPass.setEchoChar('*');
    }//GEN-LAST:event_lbNPass3MouseExited

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
            java.util.logging.Logger.getLogger(ClienSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new ClienSignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClearall;
    private javax.swing.JButton btSignup;
    private javax.swing.JComboBox<String> cbSecQues;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbConatctNo;
    private javax.swing.JLabel lbConfirmPass;
    private javax.swing.JLabel lbMail;
    private javax.swing.JLabel lbNPass2;
    private javax.swing.JLabel lbNPass3;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbSecAns;
    private javax.swing.JLabel lbSecQues;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPasswordField pfConfirm;
    private javax.swing.JPasswordField pfPass;
    private javax.swing.JTextField tfContact;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfSecurityAns;
    // End of variables declaration//GEN-END:variables

}
