package com.SpringBoot.Ecart.Payment.Repository;

import com.SpringBoot.Ecart.Payment.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
