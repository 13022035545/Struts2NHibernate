package com.dao;

import com.domain.User;

public interface UserDao {
    public User findUserByUsername(String username);
    public boolean signInUser(User user);
    public boolean updateUserPassword(User user);
}
