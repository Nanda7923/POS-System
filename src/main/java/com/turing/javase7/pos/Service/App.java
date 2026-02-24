/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.javase7.pos.Service;

import com.turing.javase7.pos.ServiceImpl.AuthServiceImpl;
import com.turing.javase7.pos.ServiceImpl.CategoryServiceImpl;
import com.turing.javase7.pos.ServiceImpl.ItemServiceImpl;
import com.turing.javase7.pos.ServiceImpl.OrderServiceImpl;

/**
 *
 * @author User
 */
public class App {
    private static App singleton;
    ItemService itemService;
    CategoryService categoryService;
    OrderService orderService;
    AuthService authService;
    
    private App(){
        this.itemService = new ItemServiceImpl();
        this.categoryService = new CategoryServiceImpl();
        this.orderService = new OrderServiceImpl();
        this.authService = new AuthServiceImpl();
    } 
    
    public static App getSingleton(){
        if(singleton == null){
            singleton = new App();
        }
        return singleton;
    }
   
    public ItemService getItemService() {
        return itemService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public AuthService getAuthService() {
        return authService;
    }
}
