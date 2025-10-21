package com.projectloki.service;

import com.projectloki.model.dto.ClientRequestDTO;
import com.projectloki.model.dto.ClientResponseDTO;
import com.projectloki.model.entity.Client;
import com.projectloki.model.entity.User;
import com.projectloki.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<User> users = clientRepository.findAll();
        return users.stream()
                .map(user -> mapperService.map(user, ClientResponseDTO.class))
                .collect(Collectors.toList());
    }

    public ClientResponseDTO getClientById(Long id) {
        User user = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        return mapperService.map(user, ClientResponseDTO.class);
    }

    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) {
        Client client = mapperService.map(clientRequestDTO, Client.class);
        client.setUpDate(java.time.LocalDate.now());
        Client savedUser = clientRepository.save(client);
        return mapperService.map(savedUser, ClientResponseDTO.class);
}

    public ClientResponseDTO updateClient(Long id, ClientResponseDTO clientRequestDTO) {
        User existingUser = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        mapperService.map(clientRequestDTO, existingUser);
        User updatedUser = clientRepository.save(existingUser);
        return mapperService.map(updatedUser, ClientResponseDTO.class);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
