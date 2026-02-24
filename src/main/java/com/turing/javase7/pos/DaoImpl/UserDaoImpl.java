/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.javase7.pos.DaoImpl;

import com.turing.javase7.pos.Dao.UserDao;
import com.turing.javase7.pos.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 *
 * @author User
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public Optional<User> getUserByUserName(String username) {
        String sql = "SELECT * FROM user "
                    +"WHERE username=?;";
        User user = null;
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("username");
                String password = result.getString("password");
                user = new User(id,name,password);
            }
            result.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void Register(String username, String password) {
        String sql = "INSERT INTO user(username,password) "
                    +"VALUES(?,SHA2(?,256));";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    

    @Override
    public void Login(String username, String password) {
        String sql = "SELECT * FROM user "
                    +"WHERE username = ? "
                    +"AND password = SHA2(?,256);";
         User user = null;
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, username);
            stmt.setString(2,password);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("username");
                String passw = result.getString("password");
                user = new User(id,name,passw);
            }
            result.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
         if(user == null){
             throw new RuntimeException("Invalid login");
         }
    }
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        userDao.Register("admin", "admin");
        
    }
}
