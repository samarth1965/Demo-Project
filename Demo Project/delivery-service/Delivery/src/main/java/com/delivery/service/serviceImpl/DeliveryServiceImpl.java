package com.delivery.service.serviceImpl;

import com.delivery.dto.DeliveryRequest;
import com.delivery.entity.Delivery;
import com.delivery.entity.DeliveryStatus;
import com.delivery.entity.Food;
import com.delivery.exception.ResourceNotFoundException;
import com.delivery.repository.DeliveryRepository;
import com.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Override
    public Delivery addDelivery(DeliveryRequest deliveryRequest) {

        Delivery delivery = new Delivery();
        delivery.setDeliveryAddress(deliveryRequest.getDeliveryAddress());
        delivery.setCustomerName(deliveryRequest.getCustomerName());
//        delivery.setOrderDetails(deliveryRequest.getOrderDetails());
        delivery.setOrderTime(LocalDateTime.now());
        delivery.setDeliveryStatus(DeliveryStatus.IN_PROGRESS);

        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery updateDelivery(Long id,DeliveryRequest deliveryRequest) {
        Delivery delivery = deliveryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("food","id",id));
        if(Objects.nonNull(deliveryRequest.getDeliveryAddress()) && !"".equalsIgnoreCase(deliveryRequest.getDeliveryAddress())){
            delivery.setDeliveryAddress(deliveryRequest.getDeliveryAddress());
        }
        if(Objects.nonNull(deliveryRequest.getCustomerName()) && !"".equalsIgnoreCase(deliveryRequest.getCustomerName())){
            delivery.setCustomerName(deliveryRequest.getCustomerName());
        }
        if(deliveryRequest.getOrderDetails()!=null){
//            delivery.getOrderDetails().addAll(deliveryRequest.getOrderDetails());
        }

        return deliveryRepository.save(delivery);
    }

    @Override
    public List<Food> getFoodInDelivery(Long id) {
        return null;
    }
}
