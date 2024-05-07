package com.example.demo.models;

//import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}


/*
The different among GenerationType.AUTO, GenerationType.IDENTITY, GenerationType.SEQUENCE, GenerationType.TABLE
GenerationType.AUTO: Hibernate selects the generation strategy based on the used dialect. The IDENTITY strategy is used when the underlying database supports auto-increment columns. If the underlying database does not support auto-increment columns, Hibernate uses a table to simulate sequence.
GenerationType.IDENTITY: Hibernate relies on an auto-incremented database column to generate the primary key. The IDENTITY strategy is supported by the following databases: MySQL, PostgreSQL, SQL Server, DB2, Sybase, and Informix.
GenerationType.SEQUENCE: Hibernate uses a database sequence to generate the primary key. The SEQUENCE strategy is supported by Oracle, PostgreSQL, DB2, and HSQLDB.
GenerationType.TABLE: Hibernate uses a database table to simulate a sequence. The TABLE strategy is supported by all databases.

 */
// Path: demo/src/main/java/com/example/demo/models/UserEntity.java