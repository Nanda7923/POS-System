/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.javase7.pos.ServiceImpl;

import com.turing.javase7.pos.Dao.OrderDao;
import com.turing.javase7.pos.DaoImpl.OrderDaoImpl;
import com.turing.javase7.pos.Service.OrderService;
import com.turing.javase7.pos.model.Order;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void addOrder(int userId, int itemId, Date date,int quantity,int total) {
        this.orderDao.addOrder(userId, itemId, date,quantity,total);
    }

    @Override
    public ArrayList<Order> getAllOrdersByUser(int userId) {
         return this.orderDao.getAllOrdersByUserId(userId);
    }

    
}
