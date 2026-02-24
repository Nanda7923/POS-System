/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.turing.javase7.pos.Service;

import com.turing.javase7.pos.model.Item;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface ItemService {
    ArrayList<Item> getAllItems();
    ArrayList<Item> getAllItemsByName(String name);
    ArrayList<Item> getAllItemsByCategoryName(String categoryName);
    void addItems(String name, int price,int stockAmount);
    void deleteItemsById(int itemId);
    void updateItem(Item item);
    void addCategoryToItem(int itemId, int categoryId);
}
