package com.build.shopping.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int  inventory;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)                                                  // Owing Side
    @JoinColumn(name= "category_id")                                                                         // Physical Foreign Key
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;


}
