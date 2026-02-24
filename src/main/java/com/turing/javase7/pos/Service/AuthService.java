/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.turing.javase7.pos.Service;

import com.turing.javase7.pos.model.User;
import java.util.Optional;

/**
 *
 * @author User
 */
public interface AuthService {
    void Register(String username, String password);
    boolean Login(String username, String password);
    void setAuthUser(User user);
    User getAuthUser();
}
