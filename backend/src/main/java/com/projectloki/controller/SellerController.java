package com.projectloki.controller;

import com.projectloki.model.dto.SellerRequestDTO;
import com.projectloki.model.dto.SellerResponseDTO;
import com.projectloki.service.SellerService;
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
@RequestMapping("/api/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/getAll")
    public List<SellerResponseDTO> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/{id}")
    public SellerResponseDTO getSellerById(Long id) {
        return sellerService.getSellerById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> crear(@Valid @RequestBody SellerRequestDTO sellerRequestDTO, BindingResult result) {
        if(result.hasErrors()){
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(),error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }
        SellerResponseDTO sellerResponseDTO = sellerService.createSeller(sellerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(sellerResponseDTO);
    }

    @PutMapping("/update/{id}")
    public SellerResponseDTO updateSeller(@PathVariable Long id, @RequestBody SellerResponseDTO sellerRequestDTO) {
        return sellerService.updateSeller(id, sellerRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSeller(Long id) {
        sellerService.deleteSeller(id);
        return ResponseEntity.ok().build();
    }

}
