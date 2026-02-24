/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.javase7.pos.ServiceImpl;

import com.turing.javase7.pos.Dao.ItemCategoryDao;
import com.turing.javase7.pos.Dao.ItemDao;
import com.turing.javase7.pos.DaoImpl.ItemCategoryDaoImpl;
import com.turing.javase7.pos.DaoImpl.ItemDaoImpl;
import com.turing.javase7.pos.Service.ItemService;
import com.turing.javase7.pos.model.Item;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ItemServiceImpl implements ItemService{
    ItemDao itemDao = new ItemDaoImpl();
    ItemCategoryDao itemCategoryDao = new ItemCategoryDaoImpl();
    @Override
    public ArrayList<Item> getAllItems() {
        return this.itemDao.getAllItems();
    }

    @Override
    public void addItems(String name, int price, int stockAmount) {
        this.itemDao.addItems(name, price, stockAmount);
    }

    @Override
    public void deleteItemsById(int itemId) {
        this.itemDao.deleteItemsById(itemId);
    }

    @Override
    public void updateItem(Item item) {
        this.itemDao.updateItem(item);
    }

    @Override
    public void addCategoryToItem(int itemId, int categoryId) {
        this.itemCategoryDao.addCategoryToItem(itemId, categoryId);
    }

    @Override
    public ArrayList<Item> getAllItemsByName(String name) {
        return this.itemDao.getAllItemsByName(name);
    }

    @Override
    public ArrayList<Item> getAllItemsByCategoryName(String categoryName) {
        return this.itemDao.getAllItemsByCategoryName(categoryName);
    }
    
}
