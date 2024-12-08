package com.SpringBoot.Ecart.Payment.Model;

import com.SpringBoot.Ecart.Order.model.Order;
import com.SpringBoot.Ecart.User.Model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@Entity
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String transactionId;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


    private  String paymentMethod;

    private  Double totalAmountWithGST;
}
