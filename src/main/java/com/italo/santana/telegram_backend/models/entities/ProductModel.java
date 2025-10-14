package com.italo.santana.telegram_backend.models.entities;

import com.italo.santana.telegram_backend.enums.ProductStatus;
import com.italo.santana.telegram_backend.enums.ProductUnit;
import com.italo.santana.telegram_backend.models.dtos.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "TB_PRODUCTS")
public class ProductModel {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "status_availability")
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Column(name = "basic_unit")
    @Enumerated(EnumType.STRING)
    private ProductUnit unit;

    @Column(name = "image")
    private String image;

    @Column(name = "created_at")
    private LocalDateTime createAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public ProductModel(ProductRequestDTO data) {
        this.name = data.name();
        this.price = data.price();
        this.status = data.status();
        this.unit = data.unit();
        this.image = data.image();
        this.createAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
