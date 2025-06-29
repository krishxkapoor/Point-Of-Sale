public class Bill extends javax.swing.JFrame {

    public Bill() {
        initComponents();
        setSize(400, 300);
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jcb = new javax.swing.JComboBox<>();
        jb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jtf);
        jtf.setBounds(120, 20, 210, 60);

        jLabel1.setText("TYPE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 150, 80, 40);

        jcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Cash", "UPI", "Card" }));
        getContentPane().add(jcb);
        jcb.setBounds(120, 150, 210, 40);

        jb.setText("Settle");
        jb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActionPerformed(evt);
            }
        });
        getContentPane().add(jb);
        jb.setBounds(150, 200, 140, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActionPerformed
        
    }//GEN-LAST:event_jbActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bill().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jb;
    private javax.swing.JComboBox<String> jcb;
    private javax.swing.JTextField jtf;
    // End of variables declaration//GEN-END:variables
}
