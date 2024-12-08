package com.SpringBoot.Ecart.Cart.Service;

import com.SpringBoot.Ecart.Config.UserContext;
import com.SpringBoot.Ecart.Order.Service.OrderService;
import com.SpringBoot.Ecart.Order.model.Order;
import com.SpringBoot.Ecart.Product.Model.Product;
import com.SpringBoot.Ecart.Product.Repository.ProductRepository;
import com.SpringBoot.Ecart.Cart.Model.Cart;
import com.SpringBoot.Ecart.Cart.Model.CartDto;
import com.SpringBoot.Ecart.Cart.Model.CartItem;
import com.SpringBoot.Ecart.Cart.Repository.CartItemRepository;
import com.SpringBoot.Ecart.Cart.Repository.CartRepository;
import com.SpringBoot.Ecart.User.Model.User;
import com.SpringBoot.Ecart.User.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;




@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

     @Autowired
     ProductRepository productRepository;


    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    private OrderService orderService;


    @Transactional
    public void addToCart(CartDto cartDto)throws Exception {

        Long userId = UserContext.getUserId();

        User user =userRepository.findById(userId).orElseThrow(() ->new Exception("user not found"));

       Cart cart = cartRepository.findByUserId(userId).orElse(new Cart());

       cart.setUser(user);

       cartRepository.save(cart);

       Product product  = productRepository.findById(cartDto.getCartItem().getTempProductId()).orElseThrow(() -> new Exception("product not found"));

       Long quantity = cartDto.getCartItem().getQuantity();
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem .setQuantity(quantity);
        cartItem.setProductprice(product.getPrice());
        calculateTotal(cartItem,cart,product);

       cartRepository.save(cart);


    }


    public Cart calculateTotal(CartItem cartItem,Cart cart,Product product){

        double itemTotal = cartItem.getQuantity()* product.getPrice();
        double gstAmount = itemTotal *(product.getGst()/100);
        cartItem.setItemtotal(itemTotal);
        cartItem.setGstamount(gstAmount);

        cartItemRepository.save(cartItem);

        List<CartItem> cartItemList = cartItemRepository.findByCartId(cart.getId());

        double finalTotal = cartItemList.stream().mapToDouble(item ->item.getItemtotal()).sum();
        double gstTotal = cartItemList.stream().mapToDouble(item ->item.getGstamount()).sum();
        double finalTotalWithGst = finalTotal + gstTotal;

        cart.setTotalPrice(finalTotal);
        cartItem.setGstamount(gstTotal);
        cart.setTotalAmountwithGST(finalTotalWithGst);

        return cart;
    }

    public Cart getCartById(Long id)throws Exception{
        Optional<Cart> cart = cartRepository.findById(Math.toIntExact(id));
        return cart.orElseThrow(() -> new RuntimeException("cart not found"));
    }


    public  Cart updateCart(Integer cartId,CartItem cartItem)throws  Exception{
        Cart cart = getCartById(Long.valueOf(cartId));

        CartItem existingItem = cartItemRepository.findByCartIdAndProductId(cart.getId(),
                Math.toIntExact(cartItem.getTempProductId())).orElseThrow(()->new Exception("cart item not found"));
Product product=productRepository.findById(cartItem.getTempProductId()).orElseThrow(()->new Exception("product not found"));
         existingItem.setQuantity(cartItem.getQuantity());
         existingItem.setProductprice(product.getPrice());

         calculateTotal(existingItem,cart, product);

         return cartRepository.save(cart);

    }
    @Transactional
    public  void deleteCartItem(Integer cartItemId)throws Exception{
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(() ->new Exception("cart item not found"));

        Cart cart = cartRepository.findById(cartItem.getCart().getId()).orElseThrow(()->new Exception("cart not found"));

        cartItemRepository.deleteById(cartItemId);

        System.out.println("Cart item deleted successfully");

        List<CartItem> existingItems = cartItemRepository.findByCartId(cart.getId());

        double finalTotal = existingItems.stream().mapToDouble(item->item.getItemtotal()).sum();
        double  gstTotal = existingItems.stream().mapToDouble(item->item.getGstamount()).sum();
        double finalTotalWithGst = finalTotal+gstTotal;

        cart.setTotalPrice(finalTotal);
        cart.setGstAmount(gstTotal);
        cart.setTotalAmountwithGST(finalTotalWithGst);
        cartRepository.save(cart);

}

public  void createOrder(Long userId) throws  Exception{

        Cart cart = cartRepository.findByUserId(userId).orElseThrow(()->new Exception("user does not exists"));


        Order order = orderService.createOrder(cart);

         cart.setOrderId(Math.toIntExact(order.getId()));

         cartRepository.save(cart);

         System.out.println("order completed sucessfully");


    }

    public void deleteCart(Long userId)throws Exception{
        Cart cart = cartRepository.findByUserId(userId).orElseThrow(()->new Exception("cart not found"));
        cartRepository.delete(cart);
    }


}
