package com.projectloki.controller;

import com.projectloki.model.dto.ClientRequestDTO;
import com.projectloki.model.dto.ClientResponseDTO;
import com.projectloki.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/getAll")
    public List<ClientResponseDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/get/{id}")
    public ClientResponseDTO getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> crear(@Valid @RequestBody ClientRequestDTO clienteRequestDTO, BindingResult result) {
        if(result.hasErrors()){
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(),error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }
        ClientResponseDTO clienteResponseDTO = clientService.createClient(clienteRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponseDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }


}
