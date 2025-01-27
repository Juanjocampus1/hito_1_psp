package com.empresa.EcoMerch.Controller.DTO;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDetailDTO {

    private Long id;
    private Long orderId;
    private Long productId;
    private int quantity;
    private BigDecimal price;
}