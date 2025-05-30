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

import com.cloud.kitchen.model.Drinks;
import com.cloud.kitchen.request.DrinksRequest;
import com.cloud.kitchen.service.DrinkService;
import com.cloud.kitchen.service.FileService;

import io.jsonwebtoken.io.IOException;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "[3] Item Controller")
@RestController
@RequestMapping("/api/v1/items/drinks")
public class DrinksController {

    @Autowired
    private DrinkService drinkService;

    @Autowired
    private FileService fileService;

    @GetMapping
    public ResponseEntity<List<Drinks>> getAllDrinks() {
        List<Drinks> drinksList = drinkService.getAllDrinks();
        return ResponseEntity.ok(drinksList);
    }

    @PostMapping(consumes = {"*/*"})
    public ResponseEntity<?> insertDrink(
    @RequestParam(value = "drinkName",required = false) String drinkName,
    @RequestParam(value = "drinkPrice",required = false) double drinkPrice,
    @RequestParam(value = "stock",required = false) int stock,
    @RequestParam(value = "imageFile",required = false) MultipartFile file
    ) throws IOException, java.io.IOException {

        DrinksRequest drinkRequest = new DrinksRequest(drinkName, drinkPrice, stock);

         MultipartFile imageFile = file;
            if (imageFile == null || imageFile.isEmpty()) {
                return ResponseEntity.badRequest().body("Image file is required");
            }

         String imagePath = fileService.saveImage(imageFile, "src/main/resources/static/images/");

        Drinks createdDrink = drinkService.insertDrink(drinkRequest,imagePath);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDrink);
    }

    @GetMapping("/{drinkId}")
    public ResponseEntity<Drinks> getDrink(@PathVariable long drinkId) {
        return drinkService.getDrinks(drinkId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

  
    //update Drink
    @PostMapping(path="/{drinkId}", consumes = {"*/*"})
    public ResponseEntity<?> updateDrink(
    @PathVariable long drinkId,
    @RequestParam(value = "drinkName",required = false) String drinkName,
    @RequestParam(value = "drinkPrice",required = false) double drinkPrice,
    @RequestParam(value = "stock",required = false) int stock,
    @RequestParam(value = "imageFile",required = false) MultipartFile file
    ) throws IOException, java.io.IOException {

        DrinksRequest drinkRequest = new DrinksRequest(drinkName, drinkPrice, stock);

         MultipartFile imageFile = file;
            if (imageFile == null || imageFile.isEmpty()) {
                return ResponseEntity.badRequest().body("Image file is required");
            }

         String imagePath = fileService.saveImage(imageFile, "src/main/resources/static/images/");

        Drinks updatedDrink = drinkService.updateDrinks(drinkId,drinkRequest,imagePath);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedDrink);
    }


    @DeleteMapping
    public ResponseEntity<?> deleteDrink(@RequestParam long drinkId) {
        drinkService.deleteDrinks(drinkId);
        return ResponseEntity.noContent().build();
    }


//retrieving image but as we r using static folder inside app to store image we dont need it rn
/* 
@GetMapping(path = "/{itemId}/image", produces = MediaType.IMAGE_JPEG_VALUE)
public byte[] getDrinkImage(@PathVariable Long itemId) throws IOException, java.io.IOException {
    Optional<Drinks> drinkWrapper = drinkService.getDrinks(itemId);
    Drinks item = drinkWrapper.orElse(null);
    
    if (item == null || item.getImagePath() == null) {
        // Handle case where item or image path is null
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item or image not found");
    }

    System.out.println(item.getImagePath());
    
    try (InputStream in = getClass().getResourceAsStream("src/main/resources/Lassi.jpg")) {
        if (in == null) {
            // Handle case where input stream is null (image resource not found)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Image resource not found");
        }
        
        return IOUtils.toByteArray(in);
    } catch (IOException e) {
        // Handle IO exception
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error reading image resource", e);
    }
}


*/     

}
