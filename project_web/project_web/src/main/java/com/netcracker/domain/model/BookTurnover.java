package com.netcracker.domain.model;

import lombok.Data;

import java.util .Date;

@Data
public class BookTurnover {
    private int inventoryNumber;
    private int userId;
    private Date dateOfGetting;
}
