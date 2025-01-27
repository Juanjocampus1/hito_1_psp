package com.empresa.EcoMerch.Repository;

import com.empresa.EcoMerch.Entities.OrderDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long> {
}
