package com.SpringBoot.Ecart.Order.model;

import com.SpringBoot.Ecart.Payment.Model.Payment;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private  Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name= "user_id",nullable = false)
    private User user;

    private  Double orderTotal;

    @Enumerated(EnumType.STRING)
    private  EOrderStatus orderStatus;

    private Double gstAmount;

    private  Double totalAmountWithGST;



     @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<Payment>payments = new ArrayList<>();


}
