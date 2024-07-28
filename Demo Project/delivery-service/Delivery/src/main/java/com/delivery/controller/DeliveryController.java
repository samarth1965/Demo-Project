package com.delivery.controller;

import com.delivery.dto.DeliveryRequest;
import com.delivery.entity.Delivery;
import com.delivery.entity.Food;
import com.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<Delivery> addDelivery(@Validated @RequestBody DeliveryRequest deliveryRequest) {
        Delivery delivery = deliveryService.addDelivery(deliveryRequest);
        return new ResponseEntity<>(delivery, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Delivery> updateDelivery(@PathVariable Long id,@Validated @RequestBody DeliveryRequest deliveryRequest) {
        Delivery delivery = deliveryService.updateDelivery(id,deliveryRequest);
        return new ResponseEntity<>(delivery, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/food")
    public ResponseEntity<List<Food>> getFoodInDelivery(@PathVariable Long id) {
        List<Food> food  = deliveryService.getFoodInDelivery(id);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }


}
