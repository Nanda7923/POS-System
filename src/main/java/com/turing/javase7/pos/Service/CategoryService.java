/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.turing.javase7.pos.Service;

import com.turing.javase7.pos.model.Category;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface CategoryService {
    ArrayList<Category> getAllCategory();
    ArrayList<Category> getAllCategoryByItemId(int itemId);
    void addCategory(String name);
    void deleteCategory(int id);
    void updateCategory(Category category);
}
