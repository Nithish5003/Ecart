package com.SpringBoot.Ecart.Product.Repository;

import com.SpringBoot.Ecart.Cart.Model.Cart;
import com.SpringBoot.Ecart.Product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {





    ;

}
