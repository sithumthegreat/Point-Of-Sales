package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.ManyToAny;

@Entity
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    @Column(nullable = false)
    private LocalDateTime orderDateTime;
    @Column(nullable=false)
    private double total_price;
    @PrePersist
    protected void onCreate(){
        this.orderDateTime=LocalDateTime.now();
    }
   


}
