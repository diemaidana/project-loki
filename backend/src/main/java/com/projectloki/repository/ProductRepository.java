package com.projectloki.repository;

import com.projectloki.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductByNameContaining(String name);

    List<Product> getProductByCategoryContaining(String category);
}
