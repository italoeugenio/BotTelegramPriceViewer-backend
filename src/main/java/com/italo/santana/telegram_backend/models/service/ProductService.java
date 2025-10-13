package com.italo.santana.telegram_backend.models.service;

import com.italo.santana.telegram_backend.models.dtos.ProductResponseDTO;
import com.italo.santana.telegram_backend.models.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponseDTO> getALl(){
        List<ProductResponseDTO> productList = productRepository.findAll().stream()
                .map(product -> new ProductResponseDTO(product))
                .toList();
        return productList;
    }


}
