package com.cloud.kitchen.service;

import java.util.List;
import java.util.Optional;

// import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.kitchen.model.Item;
import com.cloud.kitchen.model.enm.Menu;
import com.cloud.kitchen.repositories.ItemRepository;
import com.cloud.kitchen.request.ItemRequest;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;


    public List<Item> getAllItems(){

        return itemRepository.findAll();

    }

    public Item getItem(long itemId){

        Optional<Item> itemWrapper = itemRepository.findById(itemId);
        if(itemWrapper == null){
            throw new RuntimeException("Food not found");
        }else{
            return itemWrapper.get();
        }
    }
    public void deleteFoodItem(long foodItemId){

        Item item = getItem(foodItemId);

        if(item != null){

            itemRepository.deleteById(foodItemId);
        }else{
            throw new RuntimeException("Food Item not found!!");
        }
        
    }

    public Item insertFoodItem(ItemRequest itemRequest, String imagePath) {
        
        if (itemRequest.getRating()>5) {
            throw new RuntimeException("Rating cannot be more than 5");
        }


        Item item=new Item();

        if (itemRequest.getMealType().toLowerCase().equals("breakfast")) {
             item = new Item(itemRequest.getName(),itemRequest.getPrice(),Menu.BREAKFAST,imagePath,itemRequest.getRating());    
        }else if (itemRequest.getMealType().toLowerCase().equals("lunch")) {
            item = new Item(itemRequest.getName(),itemRequest.getPrice(),Menu.LUNCH,imagePath,itemRequest.getRating());
        }else{
            item = new Item(itemRequest.getName(),itemRequest.getPrice(),Menu.DINNER,imagePath,itemRequest.getRating());
        }

        itemRepository.save(item);

        return item;
    }


    public Item updateFoodItem(long itemId,ItemRequest itemRequest, String imagePath) {

        Item item=getItem(itemId);

        if (itemRequest.getRating()>5) {
            throw new RuntimeException("Rating cannot be more than 5");
        }

        if(item == null){
            throw new RuntimeException("Food Item Doesnot exists!");
        }else{

        if (itemRequest.getMealType().toLowerCase().equals("breakfast")) {
            item = new Item(itemRequest.getName(),itemRequest.getPrice(),Menu.BREAKFAST,imagePath,itemRequest.getRating());    
       }else if (itemRequest.getMealType().toLowerCase().equals("lunch")) {
           item = new Item(itemRequest.getName(),itemRequest.getPrice(),Menu.LUNCH,imagePath,itemRequest.getRating());
       }else{
           item = new Item(itemRequest.getName(),itemRequest.getPrice(),Menu.DINNER,imagePath,itemRequest.getRating());
       }
        }
        itemRepository.save(item);


        return item;
    }
    
}
