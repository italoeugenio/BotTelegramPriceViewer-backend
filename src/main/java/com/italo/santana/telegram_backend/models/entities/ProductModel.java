package com.italo.santana.telegram_backend.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.UUID;

@Data
@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private UUID id;

    @Column(name = "name")
    private String name;

}
