package com.netcracker.models;

import lombok.Data;

@Data
public class Library {

    private static Library INSTANCE = null;

    private Reader currentReader;

    private Library(){

    }

    public static Library getInstance(){
        if (INSTANCE == null) {
            synchronized (Library.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Library();
                }
            }
        }
        return INSTANCE;
    }
}