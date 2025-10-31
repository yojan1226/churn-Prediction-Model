/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connection;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TreeSet;

public class Dbconn {

   // 
    public static String trainarff_file = "C:\\churn project\\Code\\train";
    public static String testarff_file = "C:\\churn project\\Code\\test";
    public static double  ANNclass=0.0,adaclass=0.0,RFclass=0.0,DTclass=0.0,NBClass=0.0,svmclass=0.0,RNNClass=0.0;
    

    
    
    public Dbconn() throws SQLException {
        //initComponents();
        //Connection con;

    }

    public static Connection conn() throws Exception {
        Connection con;

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/churn_prediction_model", "root", "admin");

        return (con);

    }
public static int g1 = 0, g2 = 0, g3 = 0, g4 = 0, g5 = 0, g6, g7 = 0, g8, g9;
public static int count = 0;
    public static void main(String[] args) {
        TreeSet<String> list=new TreeSet<String>();
        try {
            Connection con = Dbconn.conn();
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery("select * from traindata");
            while (rs1.next()) {
                count = count + 1;

                list.add(rs1.getString("International_plan"));
               

            }

        } catch (Exception ex) {
            System.out.println(ex);
         }
        System.out.println(list);
        
        
    }

}
