package com.netcracker.domain.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;

    @ElementCollection(targetClass = Book.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "user_books", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private List<Book> handedBooks;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Book> getHandedBooks() {
        return handedBooks;
    }

    public void setHandedBooks(List<Book> handedBooks) {
        this.handedBooks = handedBooks;
    }

    @Override
    public String toString() {
        return
                "Reader: '" + username + '\'' +
                ", handed books: {" + handedBooks +
                '}';
    }
}
