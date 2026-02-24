/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.javase7.pos.DaoImpl;

import com.turing.javase7.pos.Dao.ItemDao;
import com.turing.javase7.pos.model.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ItemDaoImpl extends BaseDao implements ItemDao {
    @Override
    public ArrayList<Item> getAllItems() {
        ArrayList<Item> items = new ArrayList();
        String sql = "SELECT * FROM items;";
        try(Statement stmt = conn.createStatement()){
            ResultSet result = stmt.executeQuery(sql);
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                int price = result.getInt("price");
                int stockAmount = result.getInt("stockAmount");
                Item item = new Item(id,name,price,stockAmount);
                items.add(item);
            }
            result.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return items;
    }

    @Override
    public void addItems(String name, int price, int stockAmount) {
        String sql = "INSERT INTO items(name,price,stockAmount) "
                    +"VALUES (?,?,?);";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, name);
            stmt.setInt(2, price);
            stmt.setInt(3, stockAmount);
            stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteItemsById(int itemId) {
        String sql = "DELETE FROM items "
                    +"WHERE id=?;";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, itemId);
            stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateItem(Item item) {
        String sql = "UPDATE items "
                    +"SET name=?, price=?, stockAmount=? "
                    +"WHERE id=?;";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){  
            stmt.setString(1, item.name());
            stmt.setInt(2, item.price());
            stmt.setInt(3, item.stockAmount());
            stmt.setInt(4, item.id());
            stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<Item> getAllItemsByName(String name) {
        ArrayList<Item> items = new ArrayList();
        String sql = "SELECT * FROM items "
                    +"WHERE name LIKE '%"+name+"%'";
        try(Statement stmt = conn.createStatement()){
            ResultSet result = stmt.executeQuery(sql);
            while(result.next()){
                int id = result.getInt("id");
                String iname = result.getString("name");
                int price = result.getInt("price");
                int stockAmount = result.getInt("stockAmount");
                Item item = new Item(id,iname,price,stockAmount);
                items.add(item);
            }
            result.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return items;
    }

    @Override
    public ArrayList<Item> getAllItemsByCategoryName(String categoryName) {
        ArrayList<Item> items = new ArrayList();
        String sql ="SELECT items.id, items.name, items.price, items.stockAmount "
                    +"FROM items "
                    +"JOIN item_category ON items.id = item_category.itemId "
                    +"JOIN category  ON item_category.categoryId = category.id "
                    +"WHERE category.name like '%"+categoryName+"%'";
        try(Statement stmt = conn.createStatement()){
            
            ResultSet result = stmt.executeQuery(sql);
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                int price = result.getInt("price");
                int stockAmount = result.getInt("stockAmount");
                Item item = new Item(id,name,price,stockAmount);
                items.add(item);
            }
            result.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return items;
    }
    
}
