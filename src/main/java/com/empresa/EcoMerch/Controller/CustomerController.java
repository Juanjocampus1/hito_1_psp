package com.empresa.EcoMerch.Controller;

import com.empresa.EcoMerch.Controller.DTO.CustomerDTO;
import com.empresa.EcoMerch.Entities.Customer;
import com.empresa.EcoMerch.Service.Impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Optional<Customer> customerOptional = customerServiceImpl.findById(id);

        if (customerOptional.isPresent()){
            Customer customer = customerOptional.get();

            CustomerDTO customerDTO = CustomerDTO.builder()
                    .id(customer.getId())
                    .name(customer.getName())
                    .email(customer.getEmail())
                    .phone(customer.getPhone())
                    .address(customer.getAddress())
                    .build();
            return ResponseEntity.ok(customerDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        CustomerDTO customerDTO = CustomerDTO.builder()
                .id(customerServiceImpl.findAll().get(0).getId())
                .name(customerServiceImpl.findAll().get(0).getName())
                .email(customerServiceImpl.findAll().get(0).getEmail())
                .phone(customerServiceImpl.findAll().get(0).getPhone())
                .address(customerServiceImpl.findAll().get(0).getAddress())
                .build();
        return ResponseEntity.ok(customerDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CustomerDTO customerDTO) {

        Customer customer = Customer.builder()
                .id(customerDTO.getId())
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .phone(customerDTO.getPhone())
                .address(customerDTO.getAddress())
                .build();

        return ResponseEntity.ok(customerServiceImpl.save(customer));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {

        Customer customer = Customer.builder()
                .id(customerDTO.getId())
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .phone(customerDTO.getPhone())
                .address(customerDTO.getAddress())
                .build();

        return ResponseEntity.ok(customerServiceImpl.update(customer, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        customerServiceImpl.deleteById(id);

        return ResponseEntity.ok().build();
    }
}