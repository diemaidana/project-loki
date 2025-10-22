package com.projectloki.service;

import com.projectloki.model.dto.ClientRequestDTO;
import com.projectloki.model.dto.ClientResponseDTO;

import java.util.List;

public interface ClientService {

    List<ClientResponseDTO> getAllClients();
    ClientResponseDTO getClientById(Long id);
    ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO);
    ClientResponseDTO updateClient(Long id, ClientResponseDTO clientRequestDTO);
    void deleteClient(Long id);

}
