package com.delivery.dto;

import com.delivery.entity.Food;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRequest {

    private String customerName;

    private String deliveryAddress;

    private List<Long> orderDetails;

}
