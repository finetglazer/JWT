package com.example.demo.Service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LogoutService {
    public void LogOut() {
        SecurityContextHolder.clearContext();
    }
}
