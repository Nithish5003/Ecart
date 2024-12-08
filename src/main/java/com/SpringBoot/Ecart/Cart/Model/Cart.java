package com.SpringBoot.Ecart.Cart.Model;

import com.SpringBoot.Ecart.User.Model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name= "user_id",nullable = false)
    private  User user;


    private  Integer orderId;

    @JsonIgnore
    @OneToMany(mappedBy = "cart",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    private List<CartItem> cartItem = new ArrayList<>();

    private  Double totalPrice = 0.0;

    private Double gstAmount = 0.0;

    private  Double totalAmountwithGST = 0.0;
}
