package com.empresa.EcoMerch.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Customer {

    @Id
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
