package com.projectloki.service;

import com.projectloki.exceptions.ProductNotFoundException;
import com.projectloki.model.dto.ProductRequestDTO;
import com.projectloki.model.dto.ProductResponseDTO;
import com.projectloki.model.entities.Product;
import com.projectloki.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductResponseDTO> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductResponseDTO.class))
                .toList();
    }

    @Override
    public ProductResponseDTO getProduct(Long id) throws ProductNotFoundException{
        return modelMapper.map(
                productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado.")), ProductResponseDTO.class);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = modelMapper.map(productRequestDTO, Product.class);
        return modelMapper.map(productRepository.save(product), ProductResponseDTO.class);
    }
}
