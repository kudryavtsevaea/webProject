package com.netcracker.models;

import lombok.Data;
import lombok.ToString;
import java.sql.CallableStatement;
import java.sql.SQLException;

@Data
@ToString
public class Reader implements Comparable<Reader>{
    private int id;
    private String name;
    private Library lib = Library.getInstance();

    public Reader(String name) throws SQLException {
        this.name = name;
        CallableStatement  stmt = lib.getConnection().prepareCall("{insert into reader (readerName) values (?)}");
        stmt.setString(2,name);
        stmt.executeUpdate();
    }

    @Override
    public int compareTo(Reader o) {
        return this.name.compareTo(o.getName());
    }
}
