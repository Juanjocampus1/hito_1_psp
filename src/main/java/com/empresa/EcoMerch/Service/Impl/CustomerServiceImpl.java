package com.empresa.EcoMerch.Service.Impl;

import com.empresa.EcoMerch.Entities.Customer;
import com.empresa.EcoMerch.Repository.CustomerRepository;
import com.empresa.EcoMerch.Service.Inter.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer, Long id) {
        Customer customerToUpdate = customerRepository.findById(id).get();
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setPhone(customer.getPhone());
        customerToUpdate.setAddress(customer.getAddress());
        return customerRepository.save(customerToUpdate);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public Optional<Customer> findById(Long id) {
        return Optional.of(customerRepository.findById(id).get());
    }
}