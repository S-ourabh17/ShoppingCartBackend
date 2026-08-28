package com.build.shopping.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int  inventory;
    private String description;
    private Category category;

    private List<Image> images;


}
