/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.javase7.pos.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DAO {
    private static DAO singleton;
    private Connection conn;
    
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    private DAO(){
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos",
                        "root","Yinthuwin1$");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static DAO getSingleton(){
        if(singleton == null){
            singleton = new DAO();
        }
        return singleton;
    }

    public Connection getConnection() {
        return conn;
    }
    
    
}
