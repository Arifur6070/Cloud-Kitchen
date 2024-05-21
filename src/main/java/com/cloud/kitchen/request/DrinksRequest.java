package com.cloud.kitchen.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrinksRequest {

    @NotBlank(message = "drinkName is required")
    @Size(min = 3, max = 100, message = "Drink Name must be between 3 and 100 characters")
    private String drinkName;

    
    @DecimalMin(value = "0.0", message = "Drink price must be greater than 0.0")
    private double drinkPrice;

    // @NotBlank(message = "drinkName is required")
    @Min(value = 0, message = "Drink price must be greater than 0")
    private int drinkStock;

    

    public DrinksRequest(String drinkName,double drinkPrice,int drinkStock){

        this.drinkName=drinkName;
        this.drinkPrice=drinkPrice;
        this.drinkStock=drinkStock;
    }
}
