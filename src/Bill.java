import javax.swing.JOptionPane;

public class Bill extends javax.swing.JFrame {
    int total;
    public Bill() {
        initComponents();
        setSize(400, 300);
        total= Global.gtotal;
        setLocationRelativeTo(null);
        int total=0;
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

        jtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfActionPerformed(evt);
            }
        });
        jtf.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtfPropertyChange(evt);
            }
        });
        jtf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfKeyTyped(evt);
            }
        });
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
        String number = jtf.getText().trim();
        String type = (String) jcb.getSelectedItem();
        if (number.equals("") || type.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
        }
        else
        {
            String ans = myClient.pay(number, type, total);
            if (ans.equals("success"))
            {
                JOptionPane.showMessageDialog(this ,"category added successfully");
            }
            else
            {
                JOptionPane.showMessageDialog(this ,"error");
            }
        }        
    }//GEN-LAST:event_jbActionPerformed

    private void jtfPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtfPropertyChange

    }//GEN-LAST:event_jtfPropertyChange

    private void jtfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfKeyTyped
        char ch = evt.getKeyChar();
        if (!Character.isDigit(ch)) {
            evt.consume();
        }    }//GEN-LAST:event_jtfKeyTyped

    private void jtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfActionPerformed
        total+=Global.gtotal;
    }//GEN-LAST:event_jtfActionPerformed
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
