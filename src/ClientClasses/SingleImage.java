package ClientClasses;

import java.awt.Color;


public class SingleImage extends javax.swing.JPanel {

   public boolean isTvShow = false;
    public SingleImage(){
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        initComponents();
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbImage = new javax.swing.JLabel();

        setLayout(null);

        lbImage.setText("jLabel1");
        add(lbImage);
        lbImage.setBounds(0, 0, 290, 140);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lbImage;
    // End of variables declaration//GEN-END:variables
}
