package com.serviceFusion.Capstone.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Entity
@Getter
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String Description;
    private BigDecimal price;
    private String duration;
    private Long serviceProviderId;
    private ServiceCategory serviceCategory;

}
