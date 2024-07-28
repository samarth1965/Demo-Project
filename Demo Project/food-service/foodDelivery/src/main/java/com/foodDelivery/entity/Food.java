package com.foodDelivery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "food")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "food_name", nullable = false)
    private String foodName;

    @Column(name = "food_category", nullable = false)
    private String foodCategory;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)

    private Set<ImageModel> imageModelSet;


}
