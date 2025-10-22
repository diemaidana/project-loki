package com.projectloki.service;

import com.projectloki.model.dto.SellerRequestDTO;
import com.projectloki.model.dto.SellerResponseDTO;
import com.projectloki.model.entity.Seller;
import com.projectloki.repository.SellerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SellerServiceImpl implements SellerService{
    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
    }

    // Get all sellers
    public List<SellerResponseDTO> getAllSellers() {
        List<Seller> sellers = sellerRepository.findAll();
        return sellers.stream()
                .map(seller -> modelMapper.map(seller, SellerResponseDTO.class))
                .toList();
    }

    // Obtener por id
    public SellerResponseDTO getSellerById(Long id) {
        Seller seller = sellerRepository.findById(id).orElseThrow(() -> new RuntimeException("Seller not found"));
        return modelMapper.map(seller, SellerResponseDTO.class);
    }

    // Crear vendedor
    public SellerResponseDTO createSeller(SellerRequestDTO sellerRequestDTO) {
        Seller seller = modelMapper.map(sellerRequestDTO, Seller.class);
        seller.setUpDate(java.time.LocalDate.now());
        Seller savedSeller = sellerRepository.save(seller);
        return modelMapper.map(savedSeller, SellerResponseDTO.class);
    }

    // Actualizar vendedor
    public SellerResponseDTO updateSeller(Long id, SellerResponseDTO sellerRequestDTO) {
        Seller existingSeller = sellerRepository.findById(id).orElseThrow(() -> new RuntimeException("Seller not found"));
        modelMapper.map(sellerRequestDTO, existingSeller);
        Seller updatedSeller = sellerRepository.save(existingSeller);
        return modelMapper.map(updatedSeller, SellerResponseDTO.class);
    }

    // Eliminar vendedor
    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }
}
