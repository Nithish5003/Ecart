package com.SpringBoot.Ecart.Payment.Controller;

import com.SpringBoot.Ecart.Config.UserContext;
import com.SpringBoot.Ecart.Payment.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    public  String createOrder(@RequestParam Integer orderId,boolean fail)throws  Exception{
        Long userId = UserContext.getUserId();
        return paymentService.completePayment(userId,orderId,fail);
    }
}
