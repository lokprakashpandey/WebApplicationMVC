/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lok.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lokpr
 */
public class DatabaseConnection {

    static Connection getConnectionObject(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/userdb", "root", "");  
        } 
        catch (Exception ex) {
        } 
        return con;
    }
}
