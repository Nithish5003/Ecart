package com.SpringBoot.Ecart.Address.Model;

import com.SpringBoot.Ecart.User.Model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private  int postalCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
