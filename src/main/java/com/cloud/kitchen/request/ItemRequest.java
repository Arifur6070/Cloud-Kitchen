package com.cloud.kitchen.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class ItemRequest {
 
    private String name;
    private double price;
    private String mealType;
    private String imagePath;
    private double rating;
    
    public ItemRequest(String name,double price,String meal_type,double rating){

        this.name=name;
        this.price=price;
        this.mealType=meal_type;
        this.rating=rating;

    }
}
