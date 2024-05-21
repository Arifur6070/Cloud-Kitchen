package com.cloud.kitchen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.kitchen.model.Item;
import com.cloud.kitchen.request.ItemRequest;
import com.cloud.kitchen.service.FileService;
import com.cloud.kitchen.service.ItemService;

import io.jsonwebtoken.io.IOException;

@RestController
@RequestMapping("/api/v1/items/food")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    FileService fileService;

    @GetMapping
    public ResponseEntity<List<Item>> getAllDrinks() {
        List<Item> itemList = itemService.getAllItems();
        return ResponseEntity.ok(itemList);
    }

    @GetMapping("/{foodItemId}")
    public ResponseEntity<?> getFoodItem(@PathVariable long foodItemId) {
      Item item = itemService.getItem(foodItemId);

      if (item == null) {

        return ResponseEntity.badRequest().build();
        
      }

      return ResponseEntity.ok(item);
    }


    @PostMapping(consumes = {"*/*"})
    public ResponseEntity<?> insertFoodItem(
    @RequestParam(value = "foodName",required = false) String foodName,
    @RequestParam(value = "foodPrice",required = false) double foodPrice,
    @RequestParam(value = "meal_type",required = false) String meal_type,
    @RequestParam(value = "rating",required = false) double rating,
    @RequestParam(value = "imageFile",required = false) MultipartFile file
    ) throws IOException, java.io.IOException {

        ItemRequest itemRequest = new ItemRequest(foodName, foodPrice, meal_type,rating);

         MultipartFile imageFile = file;
            if (imageFile == null || imageFile.isEmpty()) {
                return ResponseEntity.badRequest().body("Image file is required");
            }

         String imagePath = fileService.saveImage(imageFile, "src/main/resources/static/images/");

        Item createdFoodItem = itemService.insertFoodItem(itemRequest,imagePath);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFoodItem);
    }
    @PostMapping(path = "/{foodItemId}",consumes = {"*/*"})
    public ResponseEntity<?> updateFoodItem(
    @PathVariable long foodItemId,
    @RequestParam(value = "foodName",required = false) String foodName,
    @RequestParam(value = "foodPrice",required = false) double foodPrice,
    @RequestParam(value = "meal_type",required = false) String meal_type,
    @RequestParam(value = "rating",required = false) double rating,
    @RequestParam(value = "imageFile",required = false) MultipartFile file
    ) throws IOException, java.io.IOException {

        ItemRequest itemRequest = new ItemRequest(foodName, foodPrice, meal_type,rating);

         MultipartFile imageFile = file;
            if (imageFile == null || imageFile.isEmpty()) {
                return ResponseEntity.badRequest().body("Image file is required");
            }

         String imagePath = fileService.saveImage(imageFile, "src/main/resources/static/images/");

        Item createdFoodItem = itemService.updateFoodItem(foodItemId,itemRequest,imagePath);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFoodItem);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteFoodItem(@RequestParam long foodItemId) {
        itemService.deleteFoodItem(foodItemId);
        return ResponseEntity.accepted().build();
    }

    
}
