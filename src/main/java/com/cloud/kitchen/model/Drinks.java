package com.cloud.kitchen.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Table(name = "drinks")
@Entity
public class Drinks implements Serializable{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long drinkId;
    private String drinkName;
    private double drinkPrice;
    private int stock;
    private String imagePath;


    public Drinks(String drinkName,double drinkPrice,int stock){

        this.drinkName=drinkName;
        this.drinkPrice=drinkPrice;
        this.stock=stock;
    }
}
