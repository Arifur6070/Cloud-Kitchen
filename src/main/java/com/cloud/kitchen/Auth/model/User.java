package com.cloud.kitchen.Auth.model;



import java.util.List;

import com.cloud.kitchen.model.Address;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Table(name = "users")
@Entity
public class User {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference 
    private List<Address> addresses;

    private String imagePath;

    public User(String firstName, String lastName, String email, String encodedPassword) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=encodedPassword;

    }
    
}
