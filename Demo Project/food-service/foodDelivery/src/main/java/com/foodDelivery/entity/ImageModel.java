package com.foodDelivery.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Image")
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

    @Column(length = 65555)
    private byte[] picture;

    @ManyToOne
    @JoinColumn(name = "image_p")
    @JsonBackReference
    private Food food;

    public ImageModel(String name, String type, byte[] picture) {
        this.name = name;
        this.type = type;
        this.picture = picture;
    }
}
