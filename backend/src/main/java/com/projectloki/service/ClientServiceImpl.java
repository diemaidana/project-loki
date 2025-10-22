package com.projectloki.service;

import com.projectloki.model.dto.ClientRequestDTO;
import com.projectloki.model.dto.ClientResponseDTO;
import com.projectloki.model.entity.Client;
import com.projectloki.model.entity.User;
import com.projectloki.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ModelMapper mapperService;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.mapperService = modelMapper;
    }

    public List<ClientResponseDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> mapperService.map(client, ClientResponseDTO.class))
                .collect(Collectors.toList());
    }

    public ClientResponseDTO getClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        return mapperService.map(client, ClientResponseDTO.class);
    }

    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) {
        Client client = mapperService.map(clientRequestDTO, Client.class);
        client.setUpDate(java.time.LocalDate.now());
        Client savedUser = clientRepository.save(client);
        return mapperService.map(savedUser, ClientResponseDTO.class);
}

    public ClientResponseDTO updateClient(Long id, ClientResponseDTO clientRequestDTO) {
        Client existingClient = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        mapperService.map(clientRequestDTO, existingClient);
        Client updatedClient = clientRepository.save(existingClient);
        return mapperService.map(updatedClient, ClientResponseDTO.class);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
