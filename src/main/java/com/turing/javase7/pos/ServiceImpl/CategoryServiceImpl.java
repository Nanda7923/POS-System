/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.javase7.pos.ServiceImpl;

import com.turing.javase7.pos.Dao.CategoryDao;
import com.turing.javase7.pos.DaoImpl.CategoryDaoImpl;
import com.turing.javase7.pos.Service.CategoryService;
import com.turing.javase7.pos.model.Category;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public ArrayList<Category> getAllCategory() {
        return this.categoryDao.getAllCategory();
    }

    @Override
    public void addCategory(String name) {
        this.categoryDao.addCategory(name);
    }

    @Override
    public void deleteCategory(int id) {
        this.categoryDao.deleteCategory(id);
    }

    @Override
    public void updateCategory(Category category) {
        this.categoryDao.updateCategory(category);
    }

    @Override
    public ArrayList<Category> getAllCategoryByItemId(int itemId) {
        return this.categoryDao.getAllCategoryByItemId(itemId);
    }
    
}
