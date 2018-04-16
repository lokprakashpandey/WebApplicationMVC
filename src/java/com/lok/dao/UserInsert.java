/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lok.dao;

import com.lok.model.RegisterModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lokpr
 */
public class UserInsert {

    public static void insertUser(RegisterModel user){
        String n = user.getName();
        String e = user.getEmail();
        String p = user.getPassword();
        String g = user.getGender();
        String q = user.getQualification();
        String h = user.getHobby();
        String c = user.getComment();
        try {
//            Connection con = DatabaseConnection.getConnectionObject();
//            Statement stat = con.createStatement();
//            String sql = "insert into register values ('"
//                    +n
//                    +"','"
//                    +e
//                    +"','"
//                    +p
//                    +"','"
//                    +g
//                    +"','"
//                    +q
//                    +"','"
//                    +h
//                    +"','"
//                    +c
//                    +"')";
//                    
//            stat.execute(sql);

            String qry = "insert into register values (?,?,?,?,?,?,?)";
            PreparedStatement ps = DatabaseConnection.getConnectionObject().prepareStatement(qry);
            
            ps.setString(1, n);
            ps.setString(2, e);
            ps.setString(3, p);
            ps.setString(4, g);
            ps.setString(5, q);
            ps.setString(6, h);
            ps.setString(7, c);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
        }
    }
    
    
    public static RegisterModel checkAuthentication(String e, String p){
        try{
            Connection con = DatabaseConnection.getConnectionObject();
            Statement stat = con.createStatement();
            String sql = "select * from register where email='"+e+"' and password='"+p+"'";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.first()){
                RegisterModel m = new RegisterModel();
                m.setName(rs.getString("name"));
                m.setEmail(rs.getString("email")); 
                m.setPassword(rs.getString("password"));
                m.setGender(rs.getString("gender"));
                m.setQualification(rs.getString("qualification"));
                m.setHobby(rs.getString("hobby"));
                m.setComment(rs.getString("comment"));
                return m;
            }
        }
        catch(Exception ex){
        }
        return null;
    }
    
    
    public static void updateUser(RegisterModel user){
        String n = user.getName();
        String e = user.getEmail();
        String p = user.getPassword();
        String g = user.getGender();
        String q = user.getQualification();
        String h = user.getHobby();
        String c = user.getComment();
        try {
            Connection con = DatabaseConnection.getConnectionObject();
            //System.out.println("1111111111111111111");
            Statement stat = con.createStatement();
            //System.out.println("2222222222222222222");
            String sql = "update register set name='"
                    +n
                    +"', password='"
                    +p
                    +"', gender='"
                    +g
                    +"', qualification='"
                    +q
                    +"', hobby='"
                    +h
                    +"', comment='"
                    +c
                    +"' where email='"
                    +e
                    +"'";
                    
            //System.out.println("3333333333333333");
            stat.executeUpdate(sql);
            //System.out.println("444444444444444444");
            
            
            
            
        } catch (SQLException ex) {
        }
    }
}
