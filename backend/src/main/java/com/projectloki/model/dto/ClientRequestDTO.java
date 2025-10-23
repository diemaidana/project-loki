package com.projectloki.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientRequestDTO {

    // Identificación de usuario
    @NotBlank(message = "El nombre de usuario es obligatorio.")
    @Size(min = 4, max = 20, message = "El username debe tener entre 4 y 20 caracteres.")
    private String username;

    // Correo Electrónico
    @NotBlank(message = "El correo electrónico es obligatorio.")
    @Email(message = "El formato del correo electrónico no es válido.")
    @Size(max = 100, message = "El email no debe exceder los 100 caracteres.")
    private String email;

    // Contraseña (Seguridad)
    @NotBlank(message = "La contraseña es obligatoria.")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
    // Opcional: Patrón para mayor seguridad (mínimo una mayúscula, minúscula, número, y carácter especial)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "La contraseña debe contener al menos una mayúscula, una minúscula, un número y un carácter especial.")
    private String password;

    // Nombre Completo
    @NotBlank(message = "El nombre completo es obligatorio.")
    @Size(max = 150, message = "El nombre completo no debe exceder los 150 caracteres.")
    private String fullName;

    // Documento de Identidad (DNI)
    @NotBlank(message = "El DNI es obligatorio.")
    @Pattern(regexp = "^[0-9]{7,15}$", message = "El DNI debe ser numérico y tener entre 7 y 15 dígitos.")
    private String DNI;

    // Número de Teléfono
    @NotBlank(message = "El número de teléfono es obligatorio.")
    @Pattern(regexp = "^[0-9]{8,15}$", message = "El número de teléfono debe ser numérico y tener entre 8 y 15 dígitos.")
    private String phoneNumber;

    // Dirección
    @NotBlank(message = "La dirección es obligatoria.")
    @Size(max = 250, message = "La dirección no debe exceder los 250 caracteres.")
    private String address;

    // Nacionalidad
    @NotBlank(message = "La nacionalidad es obligatoria.")
    @Size(max = 50, message = "La nacionalidad no debe exceder los 50 caracteres.")
    private String nationality;
}