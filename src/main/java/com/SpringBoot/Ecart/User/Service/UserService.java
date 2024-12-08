package com.SpringBoot.Ecart.User.Service;

import com.SpringBoot.Ecart.User.Model.User;
import com.SpringBoot.Ecart.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser() {
        return  userRepository.findAll();
    }
    public User create(User user) {
        return userRepository.save(user);
    }
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
