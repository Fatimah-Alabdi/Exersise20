package com.example.exersise19.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class AddressDTO {
    @NotNull
    private Integer teacher_id;

    @NotEmpty(message = "area cannot be empty")
    private String area;

    @NotEmpty(message = "street cannot be empty")
    private String street;
    @NotNull(message = "bulding number cannot be null")

    private int buildingNumber;
}
