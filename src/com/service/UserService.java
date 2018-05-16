package com.service;


import com.domain.User;


public interface UserService {

    public User login(String username, String password);
    public boolean sign(String username, String password, String s_password);
    public boolean changePasswordService(User user);
}
