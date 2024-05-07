package com.example.demo;

import com.example.demo.security.SecurityConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println(SecurityConstant.key);
		SpringApplication.run(DemoApplication.class, args);
	}

}
