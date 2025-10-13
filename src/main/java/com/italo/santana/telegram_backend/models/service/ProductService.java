package com.italo.santana.telegram_backend.models.service;

import com.italo.santana.telegram_backend.models.dtos.ProductResponseDTO;
import com.italo.santana.telegram_backend.models.dtos.ProductRequestDTO;
import com.italo.santana.telegram_backend.models.entities.ProductModel;
import com.italo.santana.telegram_backend.models.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponseDTO> getALl() {
        List<ProductResponseDTO> productList = productRepository.findAll().stream()
                .map(product -> new ProductResponseDTO(product))
                .toList();
        return productList;
    }

    public void saveProduct(ProductRequestDTO data) {
        ProductModel product = new ProductModel(data);
        product.setCreateAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        productRepository.save(product);
    }

    public List<ProductResponseDTO> findByName(String name){
        List<ProductResponseDTO> productList = productRepository.findAll().stream()
                .filter(product -> product.getName().toLowerCase().startsWith(name.toLowerCase()))
                .map(product -> new ProductResponseDTO(product))
                .toList();
        return productList;
    }
}
