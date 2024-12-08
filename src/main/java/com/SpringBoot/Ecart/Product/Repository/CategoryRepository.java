package com.SpringBoot.Ecart.Product.Repository;

import com.SpringBoot.Ecart.Product.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
