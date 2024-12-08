package com.SpringBoot.Ecart.Cart.Model;

import com.SpringBoot.Ecart.Product.Model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cartItems")

public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "cart_id",nullable = false)
    private  Cart cart;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
     private  Product product;

    @Transient
    private Long tempProductId;


    private  Long quantity;

    private  double gstamount;

    private double productprice;

    private  double itemtotal;





}
