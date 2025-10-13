package com.italo.santana.telegram_backend.enums;

public enum ProductUnit {
    CX("Box or package containing multiple items"),
    KG("Weight measured in kilograms"),
    SC("Bag or sack containing bulk items");

    private final String description;

    ProductUnit(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}