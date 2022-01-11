package com.netcracker.models;

public class Library {

    private static Library INSTANCE = null;

    public Reader currentReader;

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