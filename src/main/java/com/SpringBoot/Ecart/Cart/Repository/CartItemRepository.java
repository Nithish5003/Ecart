package com.SpringBoot.Ecart.Cart.Repository;

import com.SpringBoot.Ecart.Cart.Model.Cart;
import com.SpringBoot.Ecart.Cart.Model.CartItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository < CartItem, Integer>{


    Optional<CartItem> findByCartIdAndProductId(Integer id,Integer productId);

    List<CartItem> findByCartId(Integer integer);

    Integer cart(Cart cart);

     @Modifying
    @Transactional
    @Query(value = "delete from cart_items where id= :cartItemId",nativeQuery = true)
    void deleteOrderItemById(@Param("cartItemId")Integer cartItemId);
}
