package com.service;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.domain.User;

public class UserServiceImpl implements UserService{

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {

        User user = userDao.findUserByUsername(username);

        if (user != null){
            if (user.getPassword().equals(password))
                return user;
            else return null;
        }else{
            return null;
        }
    }

    @Override
    public boolean sign(String username, String password, String s_password){
        User user = null;
        /*if (username == null || password == null || s_password == null || username.equals("")
                || password.equals("") || s_password.equals("")) return false;*/


        if (password.equals(s_password)) {
            user = new User(username, password);
        }
        else return false;

        if (userDao.signInUser(user)) return true;
        else return false;
    }

    @Override
    public boolean changePasswordService(User user) {
        if(userDao.updateUserPassword(user)) return true;
        else return false;
    }
}
