package com.netcracker.models;

import lombok.Data;
import lombok.ToString;
import java.sql.SQLException;

@Data
@ToString
public class Reader implements Comparable<Reader>{
    private int id;
    private String name;

    public Reader(String name) throws SQLException {
        this.name = name;
    }

    @Override
    public int compareTo(Reader o) {
        return this.name.compareTo(o.getName());
    }
}
