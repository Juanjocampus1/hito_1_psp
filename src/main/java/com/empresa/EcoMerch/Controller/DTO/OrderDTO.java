package com.empresa.EcoMerch.Controller.DTO;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDTO {

    private Long id;
    private Long customerId;
    private LocalDate orderDate;
    private String status;
}