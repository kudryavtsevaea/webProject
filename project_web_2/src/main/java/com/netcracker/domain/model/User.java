package com.netcracker.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Role role;
    private int id;
    private String username;
    private List<Book> handedBooks;

    @Override
    public String toString() {
        return
                "Reader: '" + username + '\'' +
                ", handed books: {" + handedBooks +
                '}';
    }
}
