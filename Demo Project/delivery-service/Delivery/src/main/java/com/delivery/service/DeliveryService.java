package com.delivery.service;

import com.delivery.dto.DeliveryRequest;
import com.delivery.entity.Delivery;
import com.delivery.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryService  {
    Delivery addDelivery(DeliveryRequest deliveryRequest);

    Delivery updateDelivery(Long id,DeliveryRequest deliveryRequest);

    List<Food> getFoodInDelivery(Long id);
}
