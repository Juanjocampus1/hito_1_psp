package com.empresa.EcoMerch.Service.Inter;

import com.empresa.EcoMerch.Entities.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer save(Customer customer);
    Customer update(Customer customer, Long id);
    void deleteById(Long id);
}