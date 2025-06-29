import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerOnOff extends javax.swing.JFrame {

    myserver obj;
    public ServerOnOff() {
        initComponents();
        setSize(488, 217);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb1 = new javax.swing.JButton();
        jb2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jb1.setText("LOGIN");
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });
        getContentPane().add(jb1);
        jb1.setBounds(80, 70, 120, 60);

        jb2.setText("LOGOUT");
        jb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb2ActionPerformed(evt);
            }
        });
        getContentPane().add(jb2);
        jb2.setBounds(330, 70, 120, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb2ActionPerformed
        obj.shutdown();
    }//GEN-LAST:event_jb2ActionPerformed

    private void jb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb1ActionPerformed
        try {
            obj=new myserver(9000);
        } catch (IOException ex) {
            Logger.getLogger(ServerOnOff.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dispose();
        AdminLogin obj=new AdminLogin();
        obj.setVisible(true);
    }//GEN-LAST:event_jb1ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerOnOff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jb1;
    private javax.swing.JButton jb2;
    // End of variables declaration//GEN-END:variables
}
