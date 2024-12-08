package com.SpringBoot.Ecart.Order.Service;

import com.SpringBoot.Ecart.Cart.Model.Cart;
import com.SpringBoot.Ecart.Cart.Model.CartItem;
import com.SpringBoot.Ecart.Order.Repository.OrderItemRepository;
import com.SpringBoot.Ecart.Order.Repository.OrderRepository;
import com.SpringBoot.Ecart.Order.model.EOrderStatus;
import com.SpringBoot.Ecart.Order.model.Order;
import com.SpringBoot.Ecart.Order.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;


    public Order createOrder(Cart cart) {
        Order order = Order.builder().orderStatus(EOrderStatus.PENDING).orderTotal(cart.getTotalPrice())
                .gstAmount(cart.getGstAmount())
                .totalAmountWithGST(cart.getTotalAmountwithGST()).user(cart.getUser()).build();
        orderRepository.save(order);


        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem items : cart.getCartItem()) {
            OrderItem orderItem = OrderItem.builder().order(order).itemTotal(items.getItemtotal()).product(items.getProduct())
                    .quantity(items.getQuantity()).gstAmount(items.getGstamount())
                    .productPrice(items.getProductprice())
                    .build();

            orderItems.add(orderItem);


        }

        orderItemRepository.saveAll(orderItems);
        return order;
    }

    public void saveOrderItems(List<OrderItem>orderItems) {
        orderItemRepository.saveAll(orderItems);
    }

    public Order findOrder(Long userId,Integer orderId)throws  Exception {
        Optional<Order>maybeOrder = orderRepository.findByUserIdAndId(userId, Long.valueOf(orderId));

        if(maybeOrder.isPresent()) {
            return maybeOrder.get();
        }else {
            throw new Exception("order not found");
        }
    }

    public void  completeOrder(Order order){
        order.setOrderStatus(EOrderStatus.COMPLETED);
        orderRepository.save(order);
    }


     }

