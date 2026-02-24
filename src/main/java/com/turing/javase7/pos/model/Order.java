/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.turing.javase7.pos.model;

import java.util.Date;



/**
 *
 * @author User
 */
public record Order(int id, int userId,int itemId, Date date,int quantity,int total) {

}
