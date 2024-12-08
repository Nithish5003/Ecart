package com.SpringBoot.Ecart.Order.Repository;

import com.SpringBoot.Ecart.Order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {



    Optional<Order> findByUserIdAndId(Long userId, Long id);
}
