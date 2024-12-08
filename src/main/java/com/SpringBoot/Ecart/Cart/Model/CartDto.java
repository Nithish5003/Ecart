package com.SpringBoot.Ecart.Cart.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    Cart cart;

    CartItem cartItem;

}
