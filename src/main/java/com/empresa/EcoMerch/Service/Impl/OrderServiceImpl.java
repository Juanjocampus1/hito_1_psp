// src/main/java/com/empresa/EcoMerch/Service/Impl/OrderServiceImpl.java
package com.empresa.EcoMerch.Service.Impl;

import com.empresa.EcoMerch.Entities.Order;
import com.empresa.EcoMerch.Repository.OrderRepository;
import com.empresa.EcoMerch.Service.Inter.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order, Long id) {
        Order orderToUpdate = orderRepository.findById(id).get();
        orderToUpdate.setCustomer(order.getCustomer());
        orderToUpdate.setOrderDate(order.getOrderDate());
        return orderRepository.save(orderToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}