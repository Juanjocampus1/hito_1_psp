package com.empresa.EcoMerch.Controller;

import com.empresa.EcoMerch.Controller.DTO.OrderDetailDTO;
import com.empresa.EcoMerch.Entities.Order;
import com.empresa.EcoMerch.Entities.OrderDetail;
import com.empresa.EcoMerch.Entities.Product;
import com.empresa.EcoMerch.Service.Impl.OrderDetailServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/orderDetail")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderDetailController {

    @Autowired
    private OrderDetailServiceImpl orderDetailServiceImpl;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<OrderDetail> orderDetailOptional = orderDetailServiceImpl.findById(id);

        if(orderDetailOptional.isPresent()) {
            OrderDetail orderDetail = orderDetailOptional.get();

            OrderDetailDTO orderDetailDTO = OrderDetailDTO.builder()
                    .id(orderDetail.getId())
                    .orderId(orderDetail.getOrder().getId())
                    .productId(orderDetail.getProduct().getId())
                    .quantity(orderDetail.getQuantity())
                    .price(orderDetail.getPrice())
                    .build();
            return ResponseEntity.ok(orderDetailDTO);
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        OrderDetailDTO orderDetailDTO = OrderDetailDTO.builder()
                .id(orderDetailServiceImpl.findAll().get(0).getId())
                .orderId(orderDetailServiceImpl.findAll().get(0).getOrder().getId())
                .productId(orderDetailServiceImpl.findAll().get(0).getProduct().getId())
                .quantity(orderDetailServiceImpl.findAll().get(0).getQuantity())
                .price(orderDetailServiceImpl.findAll().get(0).getPrice())
                .build();
        return ResponseEntity.ok(orderDetailDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = OrderDetail.builder()
                .id(orderDetailDTO.getId())
                .order(Order.builder().id(orderDetailDTO.getOrderId()).build())
                .product(Product.builder().id(orderDetailDTO.getProductId()).build())
                .quantity(orderDetailDTO.getQuantity())
                .price(orderDetailDTO.getPrice())
                .build();
        return ResponseEntity.ok(orderDetailServiceImpl.save(orderDetail));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        orderDetailServiceImpl.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
