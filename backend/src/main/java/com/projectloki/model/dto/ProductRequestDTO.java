package com.projectloki.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    @NotBlank(message = "La marca es obligatoria")
    private String brand;
    @NotBlank(message = "El origen es obligatorio")
    private String origin;
    @NotBlank(message = "La descripcion es obligatoria")
    private String description;
    @NotBlank(message = "La categoria es obligatoria")
    private String category;
    @NotBlank(message = "El precio es obligatorio")
    private Double price;
    @NotBlank(message = "El stock es obligatorio")
    private Integer stock;
}
