package com.SpringBoot.Ecart.Address.Controller;

import com.SpringBoot.Ecart.Address.Model.Address;
import com.SpringBoot.Ecart.Address.Service.AddressService;
import com.SpringBoot.Ecart.User.Model.User;
import com.SpringBoot.Ecart.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/address")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public List<Address> getAllAddress() {
        return addressService.getAllAddress();
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteAddress(@PathVariable Long id){
       addressService.deleteAddress(id);
       return ResponseEntity.ok("Deleted Address");
    }


}
