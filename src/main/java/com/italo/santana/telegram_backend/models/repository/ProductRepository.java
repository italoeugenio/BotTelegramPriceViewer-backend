package com.italo.santana.telegram_backend.models.repository;

import com.italo.santana.telegram_backend.enums.ProductStatus;
import com.italo.santana.telegram_backend.models.dtos.ProductResponseDTO;
import com.italo.santana.telegram_backend.models.entities.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
    List<ProductModel> findByName(String name);
    List<ProductModel> findByPrice(BigDecimal price);
    List<ProductModel> findByStatus(ProductStatus status);
}
