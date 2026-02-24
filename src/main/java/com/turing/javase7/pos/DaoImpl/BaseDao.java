/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.javase7.pos.DaoImpl;

import java.sql.Connection;

/**
 *
 * @author User
 */
public class BaseDao {
    DAO dao = DAO.getSingleton();
    Connection conn = dao.getConnection();
}
