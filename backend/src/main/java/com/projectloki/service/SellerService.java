package com.projectloki.service;

import com.projectloki.model.dto.SellerRequestDTO;
import com.projectloki.model.dto.SellerResponseDTO;

import java.util.List;

public interface SellerService {

    List<SellerResponseDTO> getAllSellers();
    SellerResponseDTO getSellerById(Long id);
    SellerResponseDTO createSeller(SellerRequestDTO sellerRequestDTO);
    SellerResponseDTO updateSeller(Long id, SellerResponseDTO sellerRequestDTO);
    void deleteSeller(Long id);

}
