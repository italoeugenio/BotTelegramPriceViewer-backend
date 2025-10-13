package com.italo.santana.telegram_backend.models.dtos;

import com.italo.santana.telegram_backend.enums.ProductStatus;
import com.italo.santana.telegram_backend.enums.ProductUnit;
import com.italo.santana.telegram_backend.models.entities.ProductModel;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseDTO(
        UUID id,
        String name,
        BigDecimal price,
        ProductStatus status,
        ProductUnit unit,
        String image) {

    public ProductResponseDTO(ProductModel product){
        this(product.getId(), product.getName(), product.getPrice(), product.getStatus(), product.getUnit(), product.getImage());
    }
}
