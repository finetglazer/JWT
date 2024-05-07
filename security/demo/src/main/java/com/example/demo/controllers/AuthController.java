package com.example.demo.controllers;

import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.*;
import com.example.demo.dto.AuthResponseDTO;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.models.Role;
import com.example.demo.models.UserEntity;
import com.example.demo.security.JWTGenerator;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private LogoutService LogoutService;
    @Autowired
    private RegisterService RegisterService;
    @Autowired
    private JWTGenerator jwtGenerator;

    private AuthenticationManager authenticationManager;// the role is to authenticate the user
    private UserRepository userRepository;// the role is for actions with user
    private RoleRepository roleRepository;// the role is for actions with role
    private PasswordEncoder passwordEncoder;// the role is to encode the password

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto) {

        return loginService.Login(loginDto);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        LogoutService.LogOut();

        return new ResponseEntity<>(HttpStatus.OK);
    }



    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        return RegisterService.register(registerDto);
    }

    @GetMapping("/hello")
    @ResponseBody
    public UserEntity hello() {
        return userService.getUsersByUsername("gdragon");
    }

    @GetMapping("/response")
    @ResponseBody
    public Map<String, String> postResponseController() {
        return new RespondTransferService(new HashMap<>()).getText();

    }

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello World";
    }

}
