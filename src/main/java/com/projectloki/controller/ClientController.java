package com.projectloki.controller;

import com.projectloki.model.dto.ClientRequestDTO;
import com.projectloki.model.dto.ClientResponseDTO;
import com.projectloki.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/getAll")
    public List<ClientResponseDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/getById")
    public ClientResponseDTO getClientById(Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/add")
    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) {
        return clientService.createClient(clientRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }


}
