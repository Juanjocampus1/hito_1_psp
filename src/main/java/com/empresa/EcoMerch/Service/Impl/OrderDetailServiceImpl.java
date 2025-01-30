
// src/main/java/com/empresa/EcoMerch/Service/Impl/OrderDetailServiceImpl.java
package com.empresa.EcoMerch.Service.Impl;

import com.empresa.EcoMerch.Entities.OrderDetail;
import com.empresa.EcoMerch.Repository.OrderDetailRepository;
import com.empresa.EcoMerch.Service.Inter.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> findAll() {
        return (List<OrderDetail>) orderDetailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail update(OrderDetail orderDetail, Long id) {
        OrderDetail orderDetailToUpdate = orderDetailRepository.findById(id).get();
        orderDetailToUpdate.setOrder(orderDetail.getOrder());
        orderDetailToUpdate.setProduct(orderDetail.getProduct());
        orderDetailToUpdate.setQuantity(orderDetail.getQuantity());
        return orderDetailRepository.save(orderDetailToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        orderDetailRepository.deleteById(id);
    }
}
