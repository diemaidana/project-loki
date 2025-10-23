package com.projectloki.controller;

import com.projectloki.exceptions.ProductNotFoundException;
import com.projectloki.model.dto.ProductRequestDTO;
import com.projectloki.model.dto.ProductResponseDTO;
import com.projectloki.model.entity.Product;
import com.projectloki.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> getProducts(){
        List<ProductResponseDTO> products = productService.getProducts();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id){
        try{
            ProductResponseDTO product = productService.getProduct(id);
            return ResponseEntity.ok().body(product);
        }catch (ProductNotFoundException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO,
                                           BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.ok().body(productService.createProduct(productRequestDTO));
    }
}
