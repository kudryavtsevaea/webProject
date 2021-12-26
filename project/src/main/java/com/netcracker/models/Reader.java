package com.netcracker.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Reader implements Comparable<Reader>{
    private int id;
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    public Reader(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Reader o) {
        return this.name.compareTo(o.getName());
    }
}
