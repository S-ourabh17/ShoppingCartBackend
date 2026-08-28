package com.build.shopping.model;

import java.math.BigDecimal;

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
