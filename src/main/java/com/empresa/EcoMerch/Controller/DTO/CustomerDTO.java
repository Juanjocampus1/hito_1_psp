package com.empresa.EcoMerch.Controller.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
