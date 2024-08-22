package com.example.exersise19.Api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.DeleteMapping;

@Data
@AllArgsConstructor
public class ApiResponse {
    private String message;
}
