/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.turing.javase7.pos.Service;

import com.turing.javase7.pos.model.Order;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public interface OrderService {
    ArrayList<Order> getAllOrdersByUser(int userId);
    void addOrder(int userId,int itemId,Date date,int quantity, int total);
}
