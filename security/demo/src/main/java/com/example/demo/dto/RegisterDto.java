package com.example.demo.dto;

/*
The function of lombok.Data is to generate all the boilerplate that is normally
associated with simple POJOs (Plain Old Java Objects) and value objects.

Example:
    @Data
    public class User {
        private String name;
        private int age;
    }

    The @Data annotation generates getters for all fields, a useful toString method, and hashCode and equals implementations that
    follow the contract outlined in the JavaDoc. Will also generate setters for all non-final fields, as well as a constructor.
 */
import lombok.*;

@Data // data to show the data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String username;
    private String password;

    /*
    The RegisterDto class is a data transfer object that is used to transfer data between the client and the server.
     */
}
