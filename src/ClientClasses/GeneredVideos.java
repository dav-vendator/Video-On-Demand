package ClientClasses;


public class GeneredVideos extends javax.swing.JPanel {

    public GeneredVideos() {
        initComponents();
//        setSize(1024, 300);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jsGV = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jPanel1.setLayout(null);
        jsGV.setViewportView(jPanel1);

        add(jsGV);
        jsGV.setBounds(0, 30, 830, 220);

        jLabel1.setText("Genre");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 380, 20);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jsGV;
    // End of variables declaration//GEN-END:variables
}
