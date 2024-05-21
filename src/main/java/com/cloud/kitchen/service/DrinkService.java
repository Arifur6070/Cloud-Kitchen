package com.cloud.kitchen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.kitchen.model.Drinks;
import com.cloud.kitchen.repositories.DrinksRepository;
import com.cloud.kitchen.request.DrinksRequest;

@Service
public class DrinkService {

    @Autowired
    private DrinksRepository drinksRepository;
    

    public List<Drinks> getAllDrinks(){

        return drinksRepository.findAll();
    }


    public Drinks insertDrink(DrinksRequest drinkRequest,String imagePath){

        Drinks drink = new Drinks(drinkRequest.getDrinkName(),drinkRequest.getDrinkPrice(),drinkRequest.getDrinkStock());
        drink.setImagePath(imagePath);

        drinksRepository.save(drink);

        return drink;

    }

    public Optional<Drinks> getDrinks(long drinkId){

        return drinksRepository.findById(drinkId);
    }

    public Drinks updateDrinks(long drinkId, DrinksRequest drinkRequest,String imagePath){

        Drinks drinks = getDrinks(drinkId).get();
        if(drinks == null){
            throw new RuntimeException("Drink not found");
        }

        drinks.setDrinkName(drinkRequest.getDrinkName());
        drinks.setDrinkPrice(drinkRequest.getDrinkPrice());
        drinks.setStock(drinkRequest.getDrinkStock());
        drinks.setImagePath(imagePath);

        drinksRepository.save(drinks);

        return drinks;
    }


    public void deleteDrinks(long drinkId){

        Drinks drinks = getDrinks(drinkId).get();
        if(drinks == null){
            throw new RuntimeException("Drink not found");
        }

        drinksRepository.deleteById(drinkId);
    }


   

}
