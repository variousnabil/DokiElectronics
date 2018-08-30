/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokielectronics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Order extends javax.swing.JFrame {

    /**
     * Creates new form Order
     */
    ResultSet rs;
    PreparedStatement ps;
    Statement st;
    private int OrderNum ;
    //current date 
    DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("id","id"));
    String date = df.format(new Date());
    int flag;
    
    
    
    public Order() {
        initComponents();
        if(flag==0){
            AIOrderNumber();
        }
        //set current date time for order date
        txtOrderDate.setText(date);
        fillCBempid();
        this.setLocationRelativeTo(null);
        this.setTitle("Order");
    }
    
    // 1 - Fill Array list with the data 
    public ArrayList<Employee> getEmployeeList(){
        ArrayList<Employee> empList = new ArrayList<Employee>();
        try {  
            //connecting java with database
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/doki_electronics", "root", "");
            String query = "SELECT EmployeeID FROM Employee";
          
            st = con.createStatement();
            rs = st.executeQuery(query);
            Employee employee;
            
            while(rs.next()){
                employee  = new Employee(rs.getInt("EmployeeID"));
                empList.add(employee);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empList;
    }
    
    //fill checkbox empid
    public void fillCBempid(){
        ArrayList<Employee> list = getEmployeeList();
        
        String[] id = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            id[i] = String.valueOf(list.get(i).getEmpid());
        }
        
        DefaultComboBoxModel dm = new DefaultComboBoxModel(id);
        cbEmpID.setModel(dm);
    }

    
    //Auto increment order number
    public void AIOrderNumber(){
        try{
            //connecting java with database
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/doki_electronics", "root", "");
            
            st = con.createStatement();
            rs= st.executeQuery("SELECT OrderNumber from orders ORDER BY OrderNumber DESC LIMIT 1");
    
            while(rs.next()){
                setOrderNum(rs.getInt("OrderNumber"));
            }
            setOrderNum(OrderNum+1);
            txtOrderNumber.setText(String.valueOf(OrderNum));
            
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setOrderNum(int OrderNum) {
        this.OrderNum = OrderNum;
    }

    public int getOrderNum() {
        return OrderNum;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtOrderNumber = new javax.swing.JTextField();
        txtOrderDate = new javax.swing.JTextField();
        cbEmpID = new javax.swing.JComboBox<>();
        lblOrder = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(414, 386));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtOrderNumber.setEditable(false);
        txtOrderNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderNumberActionPerformed(evt);
            }
        });
        getContentPane().add(txtOrderNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 170, 40));

        txtOrderDate.setEditable(false);
        getContentPane().add(txtOrderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 170, 40));

        cbEmpID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEmpIDActionPerformed(evt);
            }
        });
        getContentPane().add(cbEmpID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 170, 40));

        lblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderMouseClicked(evt);
            }
        });
        getContentPane().add(lblOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 100, 30));

        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });
        getContentPane().add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 80, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/order_1.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbEmpIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEmpIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEmpIDActionPerformed

    private void lblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderMouseClicked
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/doki_electronics", "root", "");

            PreparedStatement ps = con.prepareStatement("INSERT INTO Orders(OrderNumber,EmployeeID,OrderDate) VALUES(?,?,?)");
            ps.setInt(1, Integer.parseInt(txtOrderNumber.getText()));
            ps.setInt(2, Integer.parseInt(cbEmpID.getSelectedItem().toString()));
            ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "order inserted");
            this.dispose();
            CashierProgram CP = new CashierProgram();
            CP.setVisible(true);
            flag=2;
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }//GEN-LAST:event_lblOrderMouseClicked

    private void txtOrderNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderNumberActionPerformed

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        MainMenu MM = new MainMenu();
        MM.setVisible(true);
        MM.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lblBackMouseClicked

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
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbEmpID;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JTextField txtOrderDate;
    private javax.swing.JTextField txtOrderNumber;
    // End of variables declaration//GEN-END:variables
}