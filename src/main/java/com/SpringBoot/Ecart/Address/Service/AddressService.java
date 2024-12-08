package com.SpringBoot.Ecart.Address.Service;

import com.SpringBoot.Ecart.Address.Model.Address;
import com.SpringBoot.Ecart.Address.Repository.AddressRepository;
import com.SpringBoot.Ecart.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Address> getAllAddress(){return addressRepository.findAll();
    }

    public  Address saveAddress(Address address){
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id){
        addressRepository.deleteById(id);
    }

}
