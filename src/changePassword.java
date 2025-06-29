
import javax.swing.JOptionPane;

public class changePassword extends javax.swing.JFrame {

    public changePassword() {
        initComponents();
        setSize(401, 333);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        newPf = new javax.swing.JPasswordField();
        confirmPf = new javax.swing.JPasswordField();
        oldPf = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("New password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 80, 120, 30);

        jLabel2.setText("Confirm password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 130, 120, 28);

        jLabel3.setText("Old password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 30, 120, 30);
        getContentPane().add(newPf);
        newPf.setBounds(200, 80, 140, 30);
        getContentPane().add(confirmPf);
        confirmPf.setBounds(200, 130, 140, 30);
        getContentPane().add(oldPf);
        oldPf.setBounds(200, 30, 140, 30);

        jButton1.setText("Forgot password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(210, 230, 140, 50);

        jButton2.setText("Change password");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(40, 230, 140, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String oldpass = oldPf.getText();
        String newpass = newPf.getText();
        String confirmpass = confirmPf.getText();

        if (oldpass.equals(newpass)) {
            JOptionPane.showMessageDialog(this, "Old Password is equals to New Password");
        }
        else if ((newpass.equals(confirmpass)) && !newpass.equals(oldpass)) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to confirm this password change?", 
                                              "Confirm Password Change", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                String ans=myClient.changePass(newpass, oldpass);
                if(ans.equals("success"))
                {
                   JOptionPane.showMessageDialog(this, "Password changed successfully!");
                   dispose();
                   AdminLogin obj=new AdminLogin();
                   obj.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(this, "Invalid pass");
                }
                
            }
        }
        else {
            if(!newpass.equals(confirmpass)) {
                JOptionPane.showMessageDialog(this, "New Password is not equal to Confirm Password");
            } 
            else{
                JOptionPane.showMessageDialog(this, "Password validation failed");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmPf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField newPf;
    private javax.swing.JPasswordField oldPf;
    // End of variables declaration//GEN-END:variables
}
