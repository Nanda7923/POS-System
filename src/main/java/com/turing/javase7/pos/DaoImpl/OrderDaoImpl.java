/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.javase7.pos.DaoImpl;

import com.turing.javase7.pos.Dao.OrderDao;
import com.turing.javase7.pos.model.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public void addOrder(int userId, int itemId, Date date,int quantity,int total) {
        String sql = "INSERT INTO orders(userId,itemId,date,quantity,total) "
                    +"VALUES(?,?,?,?,?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userId);
            stmt.setInt(2, itemId);
            stmt.setDate(3, new java.sql.Date(date.getTime()));
            stmt.setInt(4,quantity);
            stmt.setInt(5,total);
            stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<Order> getAllOrdersByUserId(int userId) {
        ArrayList<Order> orders = new ArrayList();
        String sql = "SELECT * FROM orders "
                    + "WHERE userId =?;";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userId);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                int id = result.getInt("id");
                int userid = result.getInt("userId");
                int itemId = result.getInt("itemId");
                Date date = result.getDate("date");
                int quantity = result.getInt("quantity");
                int total = result.getInt("total");
                orders.add(new Order(id, userid, itemId, date,quantity,total));
            }
            result.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return orders;
    }
    
}
