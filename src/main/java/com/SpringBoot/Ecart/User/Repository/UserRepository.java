package com.SpringBoot.Ecart.User.Repository;

import com.SpringBoot.Ecart.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    Long id(Long id);
}
