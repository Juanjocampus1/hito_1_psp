package com.empresa.EcoMerch.Controller.DTO;

import java.time.LocalDate;

public class OrderDTO {

    private Long id;
    private Long customerId;
    private LocalDate orderDate;
    private String status;

    public OrderDTO() {}

    public OrderDTO(Long id, Long customerId, LocalDate orderDate, String status) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long customerId;
        private LocalDate orderDate;
        private String status;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder customerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder orderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public OrderDTO build() {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(this.id);
            orderDTO.setCustomerId(this.customerId);
            orderDTO.setOrderDate(this.orderDate);
            orderDTO.setStatus(this.status);
            return orderDTO;
        }
    }
}