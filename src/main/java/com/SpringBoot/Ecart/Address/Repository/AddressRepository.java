package com.SpringBoot.Ecart.Address.Repository;

import com.SpringBoot.Ecart.Address.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
