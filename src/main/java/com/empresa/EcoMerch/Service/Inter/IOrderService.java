package com.empresa.EcoMerch.Service.Inter;

import com.empresa.EcoMerch.Entities.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<Order> findAll();
    Optional<Order> findById(Long id);
    Order save(Order order);
    Order update(Order order, Long id);
    void deleteById(Long id);
}