package com.empresa.EcoMerch.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private LocalDate orderDate;
    private String status;

    public Order() {}

    public Order(Long id, Customer customer, LocalDate orderDate, String status) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        private Customer customer;
        private LocalDate orderDate;
        private String status;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder customer(Customer customer) {
            this.customer = customer;
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

        public Order build() {
            Order order = new Order();
            order.setId(this.id);
            order.setCustomer(this.customer);
            order.setOrderDate(this.orderDate);
            order.setStatus(this.status);
            return order;
        }
    }
}