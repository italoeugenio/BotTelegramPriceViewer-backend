package com.italo.santana.telegram_backend.models.service;

import com.italo.santana.telegram_backend.enums.ProductStatus;
import com.italo.santana.telegram_backend.exception.ProductNotFoundException;
import com.italo.santana.telegram_backend.models.dtos.ProductResponseDTO;
import com.italo.santana.telegram_backend.models.dtos.ProductRequestDTO;
import com.italo.santana.telegram_backend.models.entities.ProductModel;
import com.italo.santana.telegram_backend.models.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponseDTO> getAll() {
        List<ProductResponseDTO> productList = productRepository.findAll().stream()
                .sorted(Comparator.comparing(product -> product.getName()))
                .map(product -> new ProductResponseDTO(product))
                .toList();
        return productList;
    }

    public void saveProduct(ProductRequestDTO data) {
        ProductModel product = new ProductModel(data);
        productRepository.save(product);
    }

    public ProductResponseDTO getById(UUID id) {
        Optional<ProductModel> product = productRepository.findById(id);
        if(product.isEmpty()) throw new ProductNotFoundException("Product not found");
        return new ProductResponseDTO(product.get());
    }

}
