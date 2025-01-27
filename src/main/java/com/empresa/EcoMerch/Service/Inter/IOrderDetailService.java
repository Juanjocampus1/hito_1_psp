package com.empresa.EcoMerch.Service.Inter;

import com.empresa.EcoMerch.Entities.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface IOrderDetailService {
    List<OrderDetail> findAll();
    Optional<OrderDetail> findById(Long id);
    OrderDetail save(OrderDetail orderDetail);
    void deleteById(Long id);
}