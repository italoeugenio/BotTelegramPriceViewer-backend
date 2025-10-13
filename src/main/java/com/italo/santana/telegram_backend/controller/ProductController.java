package com.italo.santana.telegram_backend.controller;

import com.italo.santana.telegram_backend.models.dtos.ProductResponseDTO;
import com.italo.santana.telegram_backend.models.dtos.ProductRequestDTO;
import com.italo.santana.telegram_backend.models.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/get/all")
    public ResponseEntity<List<ProductResponseDTO>> getAll(){
        return ResponseEntity.ok(productService.getALl());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("get/{name}")
    public ResponseEntity<List<ProductResponseDTO>> findByName(@PathVariable("name") String name){
        List<ProductResponseDTO> products = productService.findByName(name);
        if(products.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(products);
        }
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/post")
    public void saveProduct(@RequestBody ProductRequestDTO data){
        productService.saveProduct(data);
        return;
    }


}
