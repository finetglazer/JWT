package com.example.demo.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity getUsersByUsername(String username){
        UserEntity user = userRepository.findByUsername(username).orElseThrow(()-> new RuntimeException("User not exist"));
        return user;
    }
}
