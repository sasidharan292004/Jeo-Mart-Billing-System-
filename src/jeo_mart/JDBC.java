/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeo_mart;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class JDBC {                   
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=jeomart_billing_sys;trustServerCertificate=true";
      private static final String USER = "SASIDHARAN-S";
        private static final String PASSWORD = "sasi";
        
        public static Connection con() throws Exception{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    
}

