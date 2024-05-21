package com.cloud.kitchen.model;

import java.io.Serializable;

import com.cloud.kitchen.model.enm.Menu;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "items")
@Entity
public class Item implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;
    private String name;
    private double price;
    @Enumerated(EnumType.STRING)
    @Column(name = "meal_type")
    private Menu mealType;
    private String imagePath;
    private double rating;

    public Item(String name,double price,Menu meal_type,String imagePath,double rating){

        this.name=name;
        this.price=price;
        this.mealType=meal_type;
        this.imagePath=imagePath;
        this.rating=rating;

    }


}
