package com.margo.kata.model;

public enum AccountType {

    CURRENT(1, "Current"),
    SAVINGS(2, "Savings");

    private int typeId;

    private String typeName;

    AccountType(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }
}
