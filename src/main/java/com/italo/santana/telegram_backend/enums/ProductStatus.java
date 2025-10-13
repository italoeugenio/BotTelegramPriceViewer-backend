package com.italo.santana.telegram_backend.enums;

public enum ProductStatus {
    Available("This product is available to sell"),
    Unavailable("This is not available to sell");

    private final String description;

    ProductStatus(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
