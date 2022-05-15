package com.netcracker.domain.services;

import com.netcracker.domain.repository.TransInt;

import java.util.Date;

public class TransIntImpl implements TransInt {
    private Date oldDate = getBook();

    @Override
    public Date getBook() {
        return new Date();
    }

    @Override
    public void backBook() {
        Date date1 = oldDate;
        Date date2 = getBook();
    }
}
