package com.foodDelivery.repository;

import com.foodDelivery.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long > {
}
