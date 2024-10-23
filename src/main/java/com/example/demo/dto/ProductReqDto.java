package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ProductReqDto {

    private String name;
    private LocalDate expDate;
    private Long qty;
    private double unitPrice;
    private Long catId;
}
