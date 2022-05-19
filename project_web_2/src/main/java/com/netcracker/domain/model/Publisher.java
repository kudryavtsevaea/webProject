package com.netcracker.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Publisher: '" + name;
    }
}
