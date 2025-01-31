package com.empresa.EcoMerch.Controller;

import com.empresa.EcoMerch.Controller.DTO.OrderDTO;
import com.empresa.EcoMerch.Entities.Customer;
import com.empresa.EcoMerch.Entities.Order;
import com.empresa.EcoMerch.Service.Impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Order> orderOptional = orderServiceImpl.findById(id);

        if(orderOptional.isPresent()) {
            Order order = orderOptional.get();

            OrderDTO orderDTO = OrderDTO.builder()
                    .id(order.getId())
                    .customerId(order.getCustomer().getId())
                    .orderDate(order.getOrderDate())
                    .status(order.getStatus())
                    .build();
            return ResponseEntity.ok(orderDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<OrderDTO> orderDTOs = orderServiceImpl.findAll().stream()
                .map(order -> OrderDTO.builder()
                        .id(order.getId())
                        .customerId(order.getCustomer().getId())
                        .orderDate(order.getOrderDate())
                        .status(order.getStatus())
                        .build())
                .collect(java.util.stream.Collectors.toList());
        return ResponseEntity.ok(orderDTOs);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody OrderDTO orderDTO) {
        Order order = Order.builder()
                .id(orderDTO.getId())
                .customer(Customer.builder().id(orderDTO.getCustomerId()).build())
                .orderDate(orderDTO.getOrderDate())
                .status(orderDTO.getStatus())
                .build();
        return ResponseEntity.ok(orderServiceImpl.save(order));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody OrderDTO orderDTO, @PathVariable Long id) {
        Order order = Order.builder()
                .id(orderDTO.getId())
                .customer(Customer.builder().id(orderDTO.getCustomerId()).build())
                .orderDate(orderDTO.getOrderDate())
                .status(orderDTO.getStatus())
                .build();
        return ResponseEntity.ok(orderServiceImpl.update(order, id));
    }

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        orderServiceImpl.deleteById(id);
        return ResponseEntity.ok().build();
    }
}