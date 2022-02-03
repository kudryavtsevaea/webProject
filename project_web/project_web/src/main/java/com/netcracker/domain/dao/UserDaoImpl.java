package com.netcracker.domain.dao;

import com.netcracker.domain.model.User;
import com.netcracker.domain.services.UserRepository;

public class UserDaoImpl implements  UserDao{
    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public void addUser(User user) {
        userRepository.getUserStorage().put(user.getId(), user.getName());
    }

    @Override
    public void deleteUser(User user) {
        userRepository.getUserStorage().remove(user);
    }

    @Override
    public void updateUser(User oldUser, User newUser) {
        userRepository.getUserStorage().remove(oldUser);
        userRepository.getUserStorage().put(oldUser.getId(), newUser.getName());
    }

    public UserRepository getUserRepository(){
        return userRepository;
    }
}
