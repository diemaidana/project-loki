package com.projectloki.service;

import com.projectloki.model.dto.ProductRequestDTO;
import com.projectloki.model.dto.ProductResponseDTO;
import com.projectloki.model.entity.Seller;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getProducts();
    ProductResponseDTO getProduct(Long id);
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
}
