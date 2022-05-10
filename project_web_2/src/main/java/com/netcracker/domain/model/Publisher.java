package com.netcracker.domain.model;

import lombok.Data;

@Data
public class Publisher {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Publisher: '" + name;
    }
}
