package com.example.Entities;

<<<<<<< HEAD:src/main/java/com/example/User.java
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = -502753434853358270L;
=======

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
>>>>>>> 7c165bad11c14481b8bd0cae35563c7aec8dec1a:src/main/java/com/example/Entities/User.java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    public User(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
