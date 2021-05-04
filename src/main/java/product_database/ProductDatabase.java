/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product_database;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author pengboxue
 */
public class ProductDatabase extends JFrame implements ActionListener{
    JLabel lblResult;
    JTextField txtID;
    JButton btnFind;
    public static void main(String[] args) 
    {
        ProductDatabase app = new ProductDatabase();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(320, 240);
        app.setVisible(true);
        
    }

    public ProductDatabase()
    {
        super("Products Database");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(new JLabel("Enter payment ID:"));
        txtID = new JTextField(5);
        c.add(txtID);
        btnFind = new JButton("Find");
        c.add(btnFind);
        lblResult = new JLabel("RESULT HERE");
        c.add(lblResult);
        btnFind.addActionListener(this);
        System.out.println("hello there");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Connection con = null;
        Statement stmt = null;
        ResultSet r =null;
        
        String URL = ConnectionDetails.getURL();
        String userName =ConnectionDetails.getUserName();
        String passward = ConnectionDetails.getPassWord();
        
        System.out.println("In actionPerformed");
        
        try {
            //loads sql driver
            System.out.println("loading driver");
            Class.forName(ConnectionDetails.getDriver());
            System.out.println("loaded driver");
            System.out.println(URL);
            System.out.println(userName);
            System.out.println(passward);
            con = DriverManager.getConnection( URL, userName, passward);
            System.out.println("About to create statement");
            stmt = con.createStatement();
            String sql = "SELECT * FROM tblProduct WHERE PaymentID= '"+txtID.getText()+"';";
            
            System.out.println(sql);
            
            r = stmt.executeQuery(sql);
            
            if(r.next()){
                lblResult.setText("type:" +r.getString("PaymentType"));
            }
            else {
                lblResult.setText("not found");
            }
            con.close();
        }
        catch (SQLException sqle){
                sqle.printStackTrace();
        } 
        catch (ClassNotFoundException ex) {
                ex.printStackTrace();
        }
        
       
        finally 
        {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException ex) {
                   ex.printStackTrace();
                }
            }
        }
        
    }
    
}
