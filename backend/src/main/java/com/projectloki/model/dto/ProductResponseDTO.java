package com.projectloki.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private String name;
    private String brand;
    private String origin;
    private String description;
    private String category;
    private Double price;
    private Integer stock;
}
