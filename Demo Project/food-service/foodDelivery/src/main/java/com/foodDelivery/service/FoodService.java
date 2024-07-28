package com.foodDelivery.service;

import com.foodDelivery.entity.Food;

import java.util.List;

public interface FoodService {
    Food addFood(Food food);

    Food updateFood(Long id,Food food);

    void deleteFood(Long id);

    List<Food> getAllFood();

    Food getFoodById(Long id);

    Food createFood(Food post);
}
