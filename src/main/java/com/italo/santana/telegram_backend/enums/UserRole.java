package com.italo.santana.telegram_backend.enums;

public enum UserRole {
    OWNER("admin"),
    EMPLOYER("user");

    private final String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}