package com.empresa.EcoMerch.Service.Inter;

import com.empresa.EcoMerch.Entities.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface IOrderDetailService {
    List<OrderDetail> findAll();
    Optional<OrderDetail> findById(Long id);
    OrderDetail save(OrderDetail orderDetail);
    OrderDetail update(OrderDetail orderDetail, Long id);
    void deleteById(Long id);
}