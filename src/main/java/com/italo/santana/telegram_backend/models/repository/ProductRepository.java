package com.italo.santana.telegram_backend.models.repository;

import com.italo.santana.telegram_backend.models.entities.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

}
