package com.empresa.EcoMerch.Controller.DTO;

import java.math.BigDecimal;

public class OrderDetailDTO {

    private Long id;
    private Long orderId;
    private Long productId;
    private int quantity;
    private BigDecimal price;

    public OrderDetailDTO() {}

    public OrderDetailDTO(Long id, Long orderId, Long productId, int quantity, BigDecimal price) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long orderId;
        private Long productId;
        private int quantity;
        private BigDecimal price;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder orderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public OrderDetailDTO build() {
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setId(this.id);
            orderDetailDTO.setOrderId(this.orderId);
            orderDetailDTO.setProductId(this.productId);
            orderDetailDTO.setQuantity(this.quantity);
            orderDetailDTO.setPrice(this.price);
            return orderDetailDTO;
        }
    }
}