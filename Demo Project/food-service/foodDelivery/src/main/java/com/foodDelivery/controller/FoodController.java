package com.foodDelivery.controller;

import com.foodDelivery.entity.Food;
import com.foodDelivery.entity.ImageModel;
import com.foodDelivery.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/food")
@CrossOrigin(origins = "http://localhost:4200")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping(value = {"/create"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Food> createFood(@Validated @RequestPart("food") Food post
            , @RequestPart("imageFile") MultipartFile[] file){
//        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
        try {
            Set<ImageModel> imageModelSet = uploadImage(file);
            post.setImageModelSet(imageModelSet);

            return new ResponseEntity<>(foodService.createFood(post),HttpStatus.CREATED);
        }
        catch (Exception e){
            throw new RuntimeException("image set problem");
        }
    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModelSet = new HashSet<>();
        for(MultipartFile file: multipartFiles){
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes());
            imageModelSet.add(imageModel);
        }
        return imageModelSet;
    }
    @PostMapping
    public ResponseEntity<Food> addFood(@Validated @RequestBody Food food) throws MethodArgumentNotValidException {
        Food response =foodService.addFood(food);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id,@Validated @RequestBody Food food) throws MethodArgumentNotValidException{
        Food response =foodService.updateFood(id,food);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return new ResponseEntity<>("Food is successfully deleted", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> response =foodService.getAllFood();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
        Food response =foodService.getFoodById(id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    

}
