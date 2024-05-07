package com.example.demo.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RespondTransferService {
    private Map<String, String> text;

    public RespondTransferService(Map<String, String> text) {
        this.text = text;
    }

    public Map<String, String> getText() {
        text = new HashMap<>();
        text = Map.of("message", "User logged in successfully!");
        return text;
    }
}
