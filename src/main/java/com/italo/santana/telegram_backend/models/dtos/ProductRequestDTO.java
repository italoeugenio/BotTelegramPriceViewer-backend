package com.italo.santana.telegram_backend.models.dtos;

import com.italo.santana.telegram_backend.enums.ProductStatus;
import com.italo.santana.telegram_backend.enums.ProductUnit;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String name,
        BigDecimal price,
        ProductStatus status,
        ProductUnit unit,
        String image
) {
}
