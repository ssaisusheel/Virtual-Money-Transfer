
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chimmu123
 */
public class summary extends javax.swing.JFrame {

    /**
     * Creates new form summary
     */
    static String g,h,i,k,kl;
    public summary(String a1,String b1,String c1,String d1,String i1) {
        initComponents();
        g=a1;h=b1;i=c1;k=d1;kl=i1;
        Connection connection = null; 
 String rt="";
String driverName ="oracle.jdbc.driver.OracleDriver"; 
 
 
String serverName = "localhost"; 
String portNumber = "1521"; 
String sid = "home"; 
 
String url="jdbc:oracle:thin:@"+serverName+":"+ portNumber+":"+sid; 

 
String username = "chimmu"; 
String password = "chimmu786"; 
 
 
try { 

 Class.forName(driverName); 
 
 connection = DriverManager.getConnection(url, username, password); 
 
 } catch (ClassNotFoundException e) { 
  
 System.out.println("ClassNotFoundException : "+e.getMessage()); 
 
 } catch (SQLException e) { 

 System.out.println(e.getMessage()); 
 
 } 
try{
         Statement stmt=null;
         stmt = connection.createStatement();
          String kq="select name FROM customer where cons_id='"+i+"'";
   ResultSet rs = stmt.executeQuery(kq); 
    rs.next();
     rt=rs.getString(1);
    
}
catch(SQLException e){System.out.println("in summary"+e);}
        String jkp= "Name:"+rt+"\n"+"Cons_id:"+i+"\n"+"Bill no:"+g+"\n"+"Bill amount:"+h+"\n";
        ta.setText(jkp);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        t1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ta.setColumns(20);
        ta.setRows(5);
        jScrollPane1.setViewportView(ta);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Enter the Session Password");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Confirm Transaction");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String a=t1.getText();
        if(k.equals(a))
        {
             Connection connection = null; 
 
String driverName ="oracle.jdbc.driver.OracleDriver"; 
 
 
String serverName = "localhost"; 
String portNumber = "1521"; 
String sid = "home"; 
 
String url="jdbc:oracle:thin:@"+serverName+":"+ portNumber+":"+sid; 

 
String username = "chimmu"; 
String password = "chimmu786"; 
 
 
try { 

 Class.forName(driverName); 
 
 connection = DriverManager.getConnection(url, username, password); 
 
 } catch (ClassNotFoundException e) { 
  
 System.out.println("ClassNotFoundException : "+e.getMessage()); 
 
 } catch (SQLException e) { 

 System.out.println(e.getMessage()); 
 
 } 
try{
         Statement stmt=null;
         stmt = connection.createStatement();
            String kq="select bal from customer where cons_id='"+i+"'";
   ResultSet rs = stmt.executeQuery(kq); 
    rs.next();
    int foo = Integer.parseInt(rs.getString(1));
    if(foo>Integer.parseInt(h))
    {
            confirm c=new confirm(i,h,kl);
            c.setVisible(true);
        }
    else
    {
       JOptionPane.showMessageDialog(this, "Sorry you dont have enough balance to perform the transaction"); 
    }
}
catch(SQLException e){System.out.println("in summary 2 part"+e);}

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Enter valid session password to go ahead");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new summary(g,h,i,k,kl).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t1;
    private javax.swing.JTextArea ta;
    // End of variables declaration//GEN-END:variables
}
