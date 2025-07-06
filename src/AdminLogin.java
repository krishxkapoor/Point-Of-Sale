import javax.swing.JOptionPane;

public class AdminLogin extends javax.swing.JFrame {

    public AdminLogin() {
        initComponents();
        setSize(392, 380);
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl2 = new javax.swing.JLabel();
        jl1 = new javax.swing.JLabel();
        jpf = new javax.swing.JPasswordField();
        jtf = new javax.swing.JTextField();
        jb1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jl2.setText("Password");
        getContentPane().add(jl2);
        jl2.setBounds(50, 90, 90, 16);

        jl1.setText("Email");
        getContentPane().add(jl1);
        jl1.setBounds(50, 50, 90, 20);
        getContentPane().add(jpf);
        jpf.setBounds(150, 90, 140, 20);

        jtf.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        getContentPane().add(jtf);
        jtf.setBounds(150, 50, 140, 20);

        jb1.setText("LOGIN");
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });
        getContentPane().add(jb1);
        jb1.setBounds(130, 160, 100, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb1ActionPerformed
        String email=jtf.getText();
        String password = jpf.getText();
        String ans = myClient.AdminLogin(email, password);
        if (ans.equals("Succes"))
        {
            JOptionPane.showMessageDialog(this, "LOGIN SUCCES");
            dispose();
            adminHome obj = new adminHome();
            obj.setVisible(true);
        }
        else if (ans.equals("fail"))
        {
            JOptionPane.showMessageDialog(this ,"fail");
        }
        else
        {
            JOptionPane.showMessageDialog(this, ans);
        }
        
        
    }//GEN-LAST:event_jb1ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jb1;
    private javax.swing.JLabel jl1;
    private javax.swing.JLabel jl2;
    private javax.swing.JPasswordField jpf;
    private javax.swing.JTextField jtf;
    // End of variables declaration//GEN-END:variables
}
