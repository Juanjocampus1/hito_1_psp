package com.empresa.EcoMerch.Repository;

import com.empresa.EcoMerch.Entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}