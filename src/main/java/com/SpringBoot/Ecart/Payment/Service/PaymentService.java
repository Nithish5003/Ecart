package com.SpringBoot.Ecart.Payment.Service;

import com.SpringBoot.Ecart.Cart.Service.CartService;
import com.SpringBoot.Ecart.Order.Service.OrderService;
import com.SpringBoot.Ecart.Order.model.Order;
import com.SpringBoot.Ecart.Payment.Model.Payment;
import com.SpringBoot.Ecart.Payment.Repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartservice;

    public  String completePayment(Long userId,Integer orderId,boolean fail)throws  Exception{


        Order order = orderService.findOrder(userId, orderId);

        Payment payment = Payment.builder()
                .paymentMethod("VISA")
                .transactionId(String.valueOf(Math.random()))
                .totalAmountWithGST(order.getTotalAmountWithGST()).user(order.getUser())
                .order(order).build();

        paymentRepository.save(payment);

        orderService.completeOrder(order);

        if(fail)

            throw new Exception("payment failed");

            cartservice.deleteCart(userId);


            return "Payment success";
    }
}
