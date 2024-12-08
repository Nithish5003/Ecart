package com.SpringBoot.Ecart.User.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
     private  Long id;
    private  String email;
    private  String password;
    private  String firstname;
    private  String lastname;
    private  int number;


}
