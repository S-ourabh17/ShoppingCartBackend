package com.build.shopping.model;

import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
