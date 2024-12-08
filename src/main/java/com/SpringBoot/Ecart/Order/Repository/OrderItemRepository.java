package com.SpringBoot.Ecart.Order.Repository;

import com.SpringBoot.Ecart.Order.model.Order;
import com.SpringBoot.Ecart.Order.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository  extends JpaRepository<OrderItem,Long> {
   }
