package com.empresa.EcoMerch.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Product {

    @Id
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
}
