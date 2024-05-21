package com.cloud.kitchen.model;

import com.cloud.kitchen.Auth.model.User;
import com.cloud.kitchen.model.enm.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Table(name = "addresses")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_type")
    private AddressType addressType;
    private String roadName;
    private int houseNumber;
    private int postalCode;
    private String cityName;
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference // This annotation prevents infinite JSON looping
    private User user;

    public Address(AddressType addressType, String roadName, int houseNumber, int postalCode, String cityName,
            String countryName, User user) {

        this.addressType = addressType;
        this.roadName = roadName;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.cityName = cityName;
        this.countryName = countryName;
        this.user = user;
    }

}
