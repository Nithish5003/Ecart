package com.SpringBoot.Ecart.Order.model;

import com.SpringBoot.Ecart.Product.Model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orderItems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    @Transient
    private  Long tempOrderId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private  Product product;

    @Transient
    private  Long tempProductId;

    private  Long quantity;
    private  double productPrice;
    private double gstAmount;

    private double itemTotal;
}
