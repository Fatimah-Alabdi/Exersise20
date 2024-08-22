package com.example.exersise19.Controller;

import com.example.exersise19.Api.ApiResponse;
import com.example.exersise19.DTO.AddressDTO;
import com.example.exersise19.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @GetMapping("/get")
    public ResponseEntity findAllAddress() {
        return ResponseEntity.status(200).body(addressService.findAllTeacherAddress());
    }
    @PostMapping("/add")
    public ResponseEntity addAddressToTeacher(@Valid@RequestBody AddressDTO addressDTO) {
        addressService.addTeacherAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added successfully"));
    }
    @PutMapping("/update")
    public ResponseEntity updateAddressToTeacher(@Valid@RequestBody AddressDTO addressDTO) {
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddressFromTeacher(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher deleted successfully"));
    }
}
