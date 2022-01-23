package com.netcracker.domain.services;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {
    private HashMap <Integer, String> userStorage = new HashMap<>();

    public void add (int id, String name){
        userStorage.put(id, name);
    }
}
