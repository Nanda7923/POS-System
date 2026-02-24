/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.javase7.pos.ServiceImpl;

import com.turing.javase7.pos.Dao.UserDao;
import com.turing.javase7.pos.DaoImpl.UserDaoImpl;
import com.turing.javase7.pos.model.User;
import java.util.Optional;
import com.turing.javase7.pos.Service.AuthService;

/**
 *
 * @author User
 */
public class AuthServiceImpl implements AuthService {
    UserDao userDao = new UserDaoImpl();
    User user = null;
    @Override
    public void Register(String username, String password) {
        Optional<User> user = this.userDao.getUserByUserName(username);
        if(user.isPresent()){
            throw new RuntimeException("User already exists!");
        }else{
            this.userDao.Register(username, password);
        }
    }

    @Override
    public boolean Login(String username, String password) {
        try{
            this.setAuthUser(null);
            this.userDao.Login(username, password);
            Optional<User> authUser = this.userDao.getUserByUserName(username);
            System.out.println("Authuser"+authUser);
            this.setAuthUser(authUser.get());
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public void setAuthUser(User user) {
        this.user = user;
    }

    @Override
    public User getAuthUser() {
        return this.user;
    }
    
    
}
