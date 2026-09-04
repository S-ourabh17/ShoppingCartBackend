package com.build.shopping.repository;
import java.util.List;

import com.build.shopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategoryName(String category);

    List<Product> findByBrand(String brand);

    List<Product> findByCategoryNameAndBrand(String name, String brand);

    List<Product> findByName(String name);

    List<Product> findByBrandAndName(String brand, String name);

    Long countByBrandAndName(String brand, String name);

}
