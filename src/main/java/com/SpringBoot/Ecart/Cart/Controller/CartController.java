package com.SpringBoot.Ecart.Cart.Controller;

import com.SpringBoot.Ecart.Cart.Model.Cart;
import com.SpringBoot.Ecart.Cart.Model.CartDto;
import com.SpringBoot.Ecart.Cart.Model.CartItem;
import com.SpringBoot.Ecart.Cart.Service.CartService;
import com.SpringBoot.Ecart.Config.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public  String addToCart(@RequestBody CartDto cartDto,Integer id)throws Exception {
        try {
            cartService.addToCart(cartDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

            return "success";

    }
        @GetMapping("/{id}")
        public Cart getCart(@PathVariable Long id)throws Exception{
            return cartService.getCartById(id);


        }
        @PutMapping("/{id}")
        public Cart updateCart(@PathVariable Integer id,@RequestBody CartItem cartItem)throws Exception{
           return cartService.updateCart(id, cartItem);
        }

        @DeleteMapping("/{id}")
        public  void deleteCartItem(@PathVariable Integer cartItemId)throws Exception{

        cartService.deleteCartItem(cartItemId);
        }


        @PostMapping("/checkout")
        public String createOrder() throws Exception{
         Long UserId = UserContext.getUserId();
         cartService.createOrder(UserId);
         return "success";
        }






}


