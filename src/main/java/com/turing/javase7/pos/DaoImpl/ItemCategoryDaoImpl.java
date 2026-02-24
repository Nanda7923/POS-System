/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.javase7.pos.DaoImpl;

import com.turing.javase7.pos.Dao.ItemCategoryDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ItemCategoryDaoImpl extends BaseDao implements ItemCategoryDao {

    @Override
    public void addCategoryToItem(int itemId, int categoryId) {
        String sql = "INSERT INTO item_category(itemId,categoryId) "
                    +"VALUES (?,?);";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, itemId);
            stmt.setInt(2, categoryId);
            stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
