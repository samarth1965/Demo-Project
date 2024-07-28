package com.foodDelivery.service.impl;

import com.foodDelivery.entity.Food;
import com.foodDelivery.exception.ResourceNotFoundException;
import com.foodDelivery.repository.FoodRepository;
import com.foodDelivery.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;
    @Override
    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food updateFood(Long id,Food food) {
        Food food1 = foodRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("food","id",id));
        if(Objects.nonNull(food.getFoodName()) && !"".equalsIgnoreCase(food.getFoodName())){
            food1.setFoodName(food.getFoodName());
        }
        if(Objects.nonNull(food.getFoodCategory()) && !"".equalsIgnoreCase(food.getFoodCategory())){
            food1.setFoodCategory(food.getFoodCategory());
        }
        return foodRepository.save(food1);
    }

    @Override
    public void deleteFood(Long id) {
        Food food1 = foodRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("food","id",id));
        foodRepository.deleteById(id);
    }

    @Override
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    @Override
    public Food getFoodById(Long id) {
        Food food1 = foodRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("food","id",id));
        return food1;
    }

    @Override
    public Food createFood(Food post) {
        return foodRepository.save(post);
    }
}
