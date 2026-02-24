/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.javase7.pos.DaoImpl;

import com.turing.javase7.pos.Dao.CategoryDao;
import com.turing.javase7.pos.model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class CategoryDaoImpl extends BaseDao implements CategoryDao {

    @Override
    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> categories = new ArrayList();
        String sql = "SELECT * FROM category;";
        try(Statement stmt = conn.createStatement()){
             ResultSet result = stmt.executeQuery(sql);
             while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                Category category = new Category(id,name);
                categories.add(category);
             }
            result.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return categories;
    }

    @Override
    public void addCategory(String name) {
        String sql = "INSERT INTO category(name) "
                    +"VALUES(?);";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, name);
            stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(int id) {
        String sql = "DELETE FROM category "
                    +"WHERE id=?;";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateCategory(Category category) {
        String sql = "UPDATE category "
                    +"SET name=? "
                    +"WHERE id=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, category.name());
            stmt.setInt(2, category.id());
            stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<Category> getAllCategoryByItemId(int itemId) {
        ArrayList<Category> categories = new ArrayList();
        String sql = """
                     SELECT items.id , items.name as item, category.name as category FROM item_category
                     INNER JOIN items
                     ON items.id = item_category.itemId
                     INNER JOIN category
                     ON category.id = item_category.categoryId
                     WHERE items.id=?;
                     """;
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, itemId);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("category");
                categories.add(new Category(id,name));  
            }
            result.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return categories;
    }
    
}
