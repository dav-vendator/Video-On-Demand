package AdminClasses;


import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AddVideo extends javax.swing.JInternalFrame {
    private boolean changeable = true;
    public AddVideo(boolean change,boolean type) {
        initComponents();
        jpMovie.setVisible(false);
        jpMovie1.setVisible(false);
        cbGenre.addItem("Action");
        cbGenre.addItem("Entertainment");
        cbGenre.addItem("Family");
        cbGenre.addItem("Horror");
        cbGenre.addItem("Romantic");
        cbGenre.addItem("Thriller");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vod", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from categories");

            cbCategory.addItem("Select");
            while (rs.next()) {
                cbCategory.addItem(rs.getString("c_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.changeable = changeable;
        if(type){
            jpMovie.setVisible(false);
            jpMovie1.setVisible(true);
            cbCategory.setVisible(false);
            lbSelect.setVisible(false);
            this.setTitle("ADD TV SHOW");
            this.validate();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbCategory = new javax.swing.JComboBox<>();
        jpMovie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfTitle = new javax.swing.JTextField();
        btBrowse1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfPath1 = new javax.swing.JTextField();
        btBrowse2 = new javax.swing.JButton();
        tfPath2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfDirector = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfProducer = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbDate = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbMonth = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbYear = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cbRating = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDesc = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        btcovermo = new javax.swing.JButton();
        tfcoverphoto = new javax.swing.JTextField();
        tfsquarephoto = new javax.swing.JTextField();
        btsquaremo = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cbRating1 = new javax.swing.JComboBox<>();
        cbGenre = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jpMovie1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tfDirector2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfProducer2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfTitle2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDesc2 = new javax.swing.JTextArea();
        btAddtv = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        tfsquaretv = new javax.swing.JTextField();
        btsquaretv = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        tfcoverphototv = new javax.swing.JTextField();
        btcovertv = new javax.swing.JButton();
        lbSelect = new javax.swing.JLabel();
        lbsquare = new javax.swing.JLabel();
        lbCover = new javax.swing.JLabel();

        setTitle("ADD VIDEO");
        getContentPane().setLayout(null);

        cbCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCategoryItemStateChanged(evt);
            }
        });
        getContentPane().add(cbCategory);
        cbCategory.setBounds(380, 20, 250, 30);

        jpMovie.setLayout(null);

        jLabel1.setText("Title");
        jpMovie.add(jLabel1);
        jLabel1.setBounds(10, 10, 90, 20);

        jLabel2.setText("Video Path");
        jpMovie.add(jLabel2);
        jLabel2.setBounds(10, 60, 70, 14);
        jpMovie.add(tfTitle);
        tfTitle.setBounds(100, 10, 280, 30);

        btBrowse1.setBackground(new java.awt.Color(255, 255, 255));
        btBrowse1.setText("...");
        btBrowse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBrowse1ActionPerformed(evt);
            }
        });
        jpMovie.add(btBrowse1);
        btBrowse1.setBounds(100, 60, 45, 23);

        jLabel3.setText("Trailer Path");
        jpMovie.add(jLabel3);
        jLabel3.setBounds(10, 110, 80, 20);
        jpMovie.add(tfPath1);
        tfPath1.setBounds(170, 60, 210, 30);

        btBrowse2.setBackground(new java.awt.Color(255, 255, 255));
        btBrowse2.setText("...");
        btBrowse2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBrowse2ActionPerformed(evt);
            }
        });
        jpMovie.add(btBrowse2);
        btBrowse2.setBounds(100, 110, 45, 23);
        jpMovie.add(tfPath2);
        tfPath2.setBounds(170, 110, 210, 30);

        jLabel4.setText("Director");
        jpMovie.add(jLabel4);
        jLabel4.setBounds(10, 240, 60, 14);
        jpMovie.add(tfDirector);
        tfDirector.setBounds(100, 240, 270, 20);

        jLabel5.setText("Producer");
        jpMovie.add(jLabel5);
        jLabel5.setBounds(10, 280, 50, 20);
        jpMovie.add(tfProducer);
        tfProducer.setBounds(100, 270, 270, 20);

        jLabel7.setText("Rating");
        jpMovie.add(jLabel7);
        jLabel7.setBounds(10, 360, 80, 20);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jpMovie.add(jButton2);
        jButton2.setBounds(100, 520, 250, 40);

        jLabel10.setText("Release Date");
        jpMovie.add(jLabel10);
        jLabel10.setBounds(10, 320, 90, 20);

        cbDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30",
            "31"
        }));
        jpMovie.add(cbDate);
        cbDate.setBounds(100, 320, 80, 20);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Date");
        jpMovie.add(jLabel13);
        jLabel13.setBounds(110, 300, 60, 20);

        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Jan",
            "Feb",
            "Mar",
            "Apr",
            "May",
            "Jun",
            "Jul",
            "Aug",
            "Sep",
            "Oct",
            "Nov",
            "Dec"
        }));
        jpMovie.add(cbMonth);
        cbMonth.setBounds(190, 320, 80, 20);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Month");
        jpMovie.add(jLabel14);
        jLabel14.setBounds(190, 300, 60, 20);

        cbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "2017",
            "2018",
            "2019",
            "2020"
        }));
        jpMovie.add(cbYear);
        cbYear.setBounds(290, 320, 70, 20);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Year");
        jpMovie.add(jLabel15);
        jLabel15.setBounds(290, 300, 60, 20);

        cbRating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excellent (5)",
            "Very Good(4)",
            "Good (3)",
            "Average (2)",
            "Bad (1)"}));
jpMovie.add(cbRating);
cbRating.setBounds(100, 360, 230, 30);

taDesc.setColumns(20);
taDesc.setRows(5);
jScrollPane2.setViewportView(taDesc);

jpMovie.add(jScrollPane2);
jScrollPane2.setBounds(100, 150, 166, 70);

jLabel16.setText("Description");
jpMovie.add(jLabel16);
jLabel16.setBounds(10, 160, 70, 20);

btcovermo.setBackground(new java.awt.Color(255, 255, 255));
btcovermo.setText("...");
btcovermo.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        btcovermoActionPerformed(evt);
    }
    });
    jpMovie.add(btcovermo);
    btcovermo.setBounds(100, 440, 45, 23);
    jpMovie.add(tfcoverphoto);
    tfcoverphoto.setBounds(170, 440, 210, 30);
    jpMovie.add(tfsquarephoto);
    tfsquarephoto.setBounds(170, 480, 210, 30);

    btsquaremo.setBackground(new java.awt.Color(255, 255, 255));
    btsquaremo.setText("...");
    btsquaremo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btsquaremoActionPerformed(evt);
        }
    });
    jpMovie.add(btsquaremo);
    btsquaremo.setBounds(100, 490, 45, 23);

    jLabel17.setText("Square phto");
    jpMovie.add(jLabel17);
    jLabel17.setBounds(10, 490, 80, 20);

    jLabel18.setText("Cover photo");
    jpMovie.add(jLabel18);
    jLabel18.setBounds(10, 440, 70, 14);

    jLabel19.setText("Rating");
    jpMovie.add(jLabel19);
    jLabel19.setBounds(10, 360, 80, 20);

    cbRating1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excellent (5)",
        "Very Good(4)",
        "Good (3)",
        "Average (2)",
        "Bad (1)"}));
jpMovie.add(cbRating1);
cbRating1.setBounds(100, 360, 230, 20);
jpMovie.add(cbGenre);
cbGenre.setBounds(100, 400, 230, 30);

jLabel21.setText("Genre");
jpMovie.add(jLabel21);
jLabel21.setBounds(10, 400, 80, 20);

getContentPane().add(jpMovie);
jpMovie.setBounds(20, 80, 390, 570);

jpMovie1.setLayout(null);

jLabel11.setText("Director");
jpMovie1.add(jLabel11);
jLabel11.setBounds(10, 130, 70, 30);
jpMovie1.add(tfDirector2);
tfDirector2.setBounds(130, 130, 210, 30);

jLabel12.setText("Producer");
jpMovie1.add(jLabel12);
jLabel12.setBounds(10, 190, 70, 20);
jpMovie1.add(tfProducer2);
tfProducer2.setBounds(130, 180, 210, 30);

jLabel8.setText("Title");
jpMovie1.add(jLabel8);
jLabel8.setBounds(10, 10, 70, 20);
jpMovie1.add(tfTitle2);
tfTitle2.setBounds(130, 10, 210, 30);

jLabel6.setText("Description");
jpMovie1.add(jLabel6);
jLabel6.setBounds(10, 80, 100, 30);

taDesc2.setColumns(20);
taDesc2.setRows(5);
jScrollPane1.setViewportView(taDesc2);

jpMovie1.add(jScrollPane1);
jScrollPane1.setBounds(130, 50, 210, 70);

btAddtv.setBackground(new java.awt.Color(255, 255, 255));
btAddtv.setText("ADD");
btAddtv.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
    btAddtvActionPerformed(evt);
    }
    });
    jpMovie1.add(btAddtv);
    btAddtv.setBounds(120, 370, 210, 50);

    jLabel20.setText("Square Photo");
    jpMovie1.add(jLabel20);
    jLabel20.setBounds(10, 300, 100, 30);
    jpMovie1.add(tfsquaretv);
    tfsquaretv.setBounds(130, 300, 210, 30);

    btsquaretv.setBackground(new java.awt.Color(255, 255, 255));
    btsquaretv.setText("...");
    btsquaretv.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btsquaretvActionPerformed(evt);
        }
    });
    jpMovie1.add(btsquaretv);
    btsquaretv.setBounds(360, 300, 60, 30);

    jLabel22.setText("Cover Photo");
    jpMovie1.add(jLabel22);
    jLabel22.setBounds(10, 250, 70, 20);
    jpMovie1.add(tfcoverphototv);
    tfcoverphototv.setBounds(130, 240, 210, 30);

    btcovertv.setBackground(new java.awt.Color(255, 255, 255));
    btcovertv.setText("...");
    btcovertv.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btcovertvActionPerformed(evt);
        }
    });
    jpMovie1.add(btcovertv);
    btcovertv.setBounds(360, 240, 60, 30);

    getContentPane().add(jpMovie1);
    jpMovie1.setBounds(420, 80, 430, 450);

    lbSelect.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    lbSelect.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    lbSelect.setText("Select Category");
    getContentPane().add(lbSelect);
    lbSelect.setBounds(160, 20, 170, 30);

    lbsquare.setText("Square");
    getContentPane().add(lbsquare);
    lbsquare.setBounds(650, 530, 180, 120);

    lbCover.setText("Cover");
    getContentPane().add(lbCover);
    lbCover.setBounds(430, 530, 180, 120);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCategoryItemStateChanged
     if(changeable){
        int selectedIndex = cbCategory.getSelectedIndex();
        if (selectedIndex != 0) {
            if (selectedIndex == 1) {
                jpMovie.setVisible(true);
                jpMovie1.setVisible(false);
            } else if (selectedIndex == 2) {
                jpMovie.setVisible(false);
                jpMovie1.setVisible(true);
            }
        } else {
            jpMovie.setVisible(false);
            jpMovie1.setVisible(false);
        }
     }   
    }//GEN-LAST:event_cbCategoryItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String Title = tfTitle.getText();
        String Video_path = tfPath1.getText();
        String Trailer_path = tfPath2.getText();
        String Director = tfDirector.getText();
        String Producer = tfProducer.getText();
        String Rating = cbRating.getSelectedItem().toString();
        String Category_name = cbCategory.getSelectedItem().toString();
        String date = cbDate.getSelectedItem().toString();
        String month = cbMonth.getSelectedItem().toString();
        String year = cbYear.getSelectedItem().toString();
        String genre = cbGenre.getSelectedItem().toString();
        String desc = taDesc.getText();
        String coverphoto = tfcoverphoto.getText();
        String squarephoto = tfsquarephoto.getText();
        if (Title.isEmpty() || Video_path.isEmpty() || Trailer_path.isEmpty() || genre.isEmpty()
                || Director.isEmpty() || Producer.isEmpty() || Rating.isEmpty() || Category_name.isEmpty() || desc.isEmpty()) {

        } else {
            String dateofrelaese = date + "-" + month + "-" + year;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vod", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from videos where title='" + tfTitle.getText() + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Same Titled Movie Already exists");
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("Title", tfTitle.getText());
                    rs.updateString("Video_path", tfPath1.getText());
                    rs.updateString("Trailer_path", tfPath2.getText());
                    rs.updateString("Producer", tfProducer.getText());
                    rs.updateString("Director", tfDirector.getText());
                    rs.updateString("Rating", cbRating.getSelectedItem().toString());
                    rs.updateString("release_Date", dateofrelaese);
                    rs.updateString("Category_name", cbCategory.getSelectedItem().toString());
                    rs.updateString("description", taDesc.getText());
                    rs.updateString("cover_photo", coverphoto);
                    rs.updateString("square_photo", squarephoto);
                    rs.updateString("genre", genre);
                    rs.insertRow();
                    JOptionPane.showMessageDialog(this, "Movie Added Successsfully");

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_jButton2ActionPerformed
    }
    private void btBrowse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBrowse1ActionPerformed
        JFileChooser fc = new JFileChooser();

        int ans = fc.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f1 = fc.getSelectedFile();
            tfPath1.setText(f1.getPath());
        }


    }//GEN-LAST:event_btBrowse1ActionPerformed

    private void btBrowse2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBrowse2ActionPerformed
        JFileChooser fc = new JFileChooser();

        int ans = fc.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f2 = fc.getSelectedFile();
            tfPath2.setText(f2.getPath());
        }

    }//GEN-LAST:event_btBrowse2ActionPerformed

    private void btAddtvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddtvActionPerformed
        String Title = tfTitle2.getText();

        String Director = tfDirector2.getText();
        String Producer = tfProducer2.getText();

        String desc = taDesc2.getText();
        if (Title.isEmpty() || Director.isEmpty() || Producer.isEmpty() || desc.isEmpty()) {

        } else {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vod", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from videos where title='" + tfTitle2.getText() + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Same Titled TV Show Already exists");
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("Title", tfTitle2.getText());
                    rs.updateString("Producer", tfProducer2.getText());
                    rs.updateString("Director", tfDirector2.getText());
                    rs.updateString("Description", taDesc2.getText());
                    rs.updateString("cover_photo",tfcoverphototv.getText());
                    rs.updateString("square_photo",tfsquaretv.getText());
                    rs.updateString("Category_name", "TV");
                    rs.insertRow();
                    JOptionPane.showMessageDialog(this, "TV show Added Successsfully");

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btAddtvActionPerformed

    private void btcovermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcovermoActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        File f1 = null;
        int ans = fc.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f1 = fc.getSelectedFile();
            tfcoverphoto.setText(f1.getPath());
        }
        Image scaledInstance = null;
        Image scaledSquare = null;
        try{
           scaledInstance = ImageIO.read(f1).getScaledInstance(lbCover.getWidth(),
                                lbCover.getHeight(), Image.SCALE_SMOOTH);
           lbCover.setIcon(new ImageIcon(scaledInstance));
        }catch(IOException e){
            e.printStackTrace();
        }     
    }//GEN-LAST:event_btcovermoActionPerformed

    private void btsquaremoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsquaremoActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();

        int ans = fc.showOpenDialog(this);
        File f2 = null;
        if (ans == JFileChooser.APPROVE_OPTION) {
             f2 = fc.getSelectedFile();
            tfsquarephoto.setText(f2.getPath());
        }
        Image scaledInstance = null;
        //Image scaledSquare = null;
        try{
           scaledInstance = ImageIO.read(f2).getScaledInstance(lbsquare.getWidth(),
                                lbsquare.getHeight(), Image.SCALE_SMOOTH);
          lbsquare.setIcon(new ImageIcon(scaledInstance));
        }catch(IOException e){
            e.printStackTrace();
        }     
    }//GEN-LAST:event_btsquaremoActionPerformed

    private void btsquaretvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsquaretvActionPerformed
         JFileChooser fc = new JFileChooser();

        int ans = fc.showOpenDialog(this);
        File f2 = null;
        if (ans == JFileChooser.APPROVE_OPTION) {
             f2 = fc.getSelectedFile();
            tfsquaretv.setText(f2.getPath());
        }
        Image scaledInstance = null;
        Image scaledSquare = null;
        try{
           scaledInstance = ImageIO.read(f2).getScaledInstance(lbsquare.getWidth(),
                                lbsquare.getHeight(), Image.SCALE_SMOOTH);
           lbsquare.setIcon(new ImageIcon(scaledInstance));
        }catch(IOException e){
            e.printStackTrace();
        }    
    }//GEN-LAST:event_btsquaretvActionPerformed

    private void btcovertvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcovertvActionPerformed
         // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        File f1 = null;
        int ans = fc.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f1 = fc.getSelectedFile();
            tfcoverphototv.setText(f1.getPath());
        }
        Image scaledInstance = null;
        Image scaledSquare = null;
        try{
           scaledInstance = ImageIO.read(f1).getScaledInstance(lbCover.getWidth(),
                                lbCover.getHeight(), Image.SCALE_SMOOTH);
           lbCover.setIcon(new ImageIcon(scaledInstance));
        }catch(IOException e){
            e.printStackTrace();
        }     
    }//GEN-LAST:event_btcovertvActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddtv;
    private javax.swing.JButton btBrowse1;
    private javax.swing.JButton btBrowse2;
    private javax.swing.JButton btcovermo;
    private javax.swing.JButton btcovertv;
    private javax.swing.JButton btsquaremo;
    private javax.swing.JButton btsquaretv;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JComboBox<String> cbDate;
    private javax.swing.JComboBox<String> cbGenre;
    private javax.swing.JComboBox<String> cbMonth;
    private javax.swing.JComboBox<String> cbRating;
    private javax.swing.JComboBox<String> cbRating1;
    private javax.swing.JComboBox<String> cbYear;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpMovie;
    private javax.swing.JPanel jpMovie1;
    private javax.swing.JLabel lbCover;
    private javax.swing.JLabel lbSelect;
    private javax.swing.JLabel lbsquare;
    private javax.swing.JTextArea taDesc;
    private javax.swing.JTextArea taDesc2;
    private javax.swing.JTextField tfDirector;
    private javax.swing.JTextField tfDirector2;
    private javax.swing.JTextField tfPath1;
    private javax.swing.JTextField tfPath2;
    private javax.swing.JTextField tfProducer;
    private javax.swing.JTextField tfProducer2;
    private javax.swing.JTextField tfTitle;
    private javax.swing.JTextField tfTitle2;
    private javax.swing.JTextField tfcoverphoto;
    private javax.swing.JTextField tfcoverphototv;
    private javax.swing.JTextField tfsquarephoto;
    private javax.swing.JTextField tfsquaretv;
    // End of variables declaration//GEN-END:variables

}
