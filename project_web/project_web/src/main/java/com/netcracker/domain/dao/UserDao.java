package com.netcracker.domain.dao;

import com.netcracker.domain.model.User;

public interface UserDao {
    void addUser(User user);
    void deleteUser(User user);
    void updateUser(User oldUser, User newUser);
}
