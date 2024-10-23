package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

import com.example.demo.entity.ProductEntity;
@Getter
@Setter
public class OrderReqDto {
    private List<ProductEntity> productIds;
    

}
