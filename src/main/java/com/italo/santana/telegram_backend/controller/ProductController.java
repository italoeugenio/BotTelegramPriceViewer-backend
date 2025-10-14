package com.italo.santana.telegram_backend.controller;

import com.italo.santana.telegram_backend.models.dtos.ProductResponseDTO;
import com.italo.santana.telegram_backend.models.dtos.ProductRequestDTO;
import com.italo.santana.telegram_backend.models.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/get/all")
    public ResponseEntity<List<ProductResponseDTO>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductResponseDTO> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/post")
    public void saveProduct(@RequestBody ProductRequestDTO data) {
        productService.saveProduct(data);
        return;
    }


}
