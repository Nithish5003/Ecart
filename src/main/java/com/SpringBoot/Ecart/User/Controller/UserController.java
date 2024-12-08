package com.SpringBoot.Ecart.User.Controller;

import com.SpringBoot.Ecart.User.Model.User;
import com.SpringBoot.Ecart.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
     UserService userService;

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();}
    @PostMapping
    public  User createUser(@RequestBody User user){
        return  userService.create(user);
    }

@DeleteMapping("/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
