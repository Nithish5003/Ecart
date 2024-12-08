package com.SpringBoot.Ecart.Cart.Repository;

import com.SpringBoot.Ecart.Cart.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> Id(Integer id);

    @Override
    Optional<Cart> findById(Integer integer);

    Optional<Cart> findByUserId(Long id);
}
