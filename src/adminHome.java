public class adminHome extends javax.swing.JFrame {

    public adminHome() {
        initComponents();
        setSize(507, 351);
        setLocationRelativeTo(null);
                             
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb1 = new javax.swing.JButton();
        jb2 = new javax.swing.JButton();
        jb3 = new javax.swing.JButton();
        jb4 = new javax.swing.JButton();
        jb5 = new javax.swing.JButton();
        jb6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jb1.setText("Categories");
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });
        getContentPane().add(jb1);
        jb1.setBounds(50, 50, 120, 50);

        jb2.setText("Products");
        jb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb2ActionPerformed(evt);
            }
        });
        getContentPane().add(jb2);
        jb2.setBounds(180, 50, 120, 50);

        jb3.setText("Change Password");
        jb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb3ActionPerformed(evt);
            }
        });
        getContentPane().add(jb3);
        jb3.setBounds(310, 50, 120, 50);

        jb4.setText("Generate Bill");
        jb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb4ActionPerformed(evt);
            }
        });
        getContentPane().add(jb4);
        jb4.setBounds(50, 200, 120, 50);

        jb5.setText("Bill History");
        jb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb5ActionPerformed(evt);
            }
        });
        getContentPane().add(jb5);
        jb5.setBounds(180, 200, 120, 50);

        jb6.setText("Logout");
        jb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb6ActionPerformed(evt);
            }
        });
        getContentPane().add(jb6);
        jb6.setBounds(310, 200, 120, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb1ActionPerformed
        dispose();
        mngCategories obj = new mngCategories();
        obj.setVisible(true);
    }//GEN-LAST:event_jb1ActionPerformed

    private void jb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb2ActionPerformed
        dispose();
        mngProducts obj = new mngProducts();
        obj.setVisible(true);
    }//GEN-LAST:event_jb2ActionPerformed

    private void jb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb4ActionPerformed
        dispose();
        GenrateBill obj = new GenrateBill();
        obj.setVisible(true);
    }//GEN-LAST:event_jb4ActionPerformed

    private void jb6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb6ActionPerformed
        dispose();
        AdminLogin obj = new AdminLogin();
        obj.setVisible(true);
    }//GEN-LAST:event_jb6ActionPerformed

    private void jb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb3ActionPerformed
        dispose();
        changePassword obj = new changePassword();
        obj.setVisible(true);
    }//GEN-LAST:event_jb3ActionPerformed

    private void jb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb5ActionPerformed
        dispose();
        BillHistory obj =new BillHistory();
        obj.setVisible(true);
    }//GEN-LAST:event_jb5ActionPerformed

    
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jb1;
    private javax.swing.JButton jb2;
    private javax.swing.JButton jb3;
    private javax.swing.JButton jb4;
    private javax.swing.JButton jb5;
    private javax.swing.JButton jb6;
    // End of variables declaration//GEN-END:variables
}
