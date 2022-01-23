package com.netcracker.models;

import lombok.Data;
import lombok.ToString;
import java.sql.SQLException;

@Data
@ToString
public class Reader implements Comparable<Reader>{
    private long id;
    private String name;

    public Reader(long id, String name) throws SQLException {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Reader o) {
        return this.name.compareTo(o.getName());
    }
}
