package com.build.shopping.repository;

import com.build.shopping.model.Category;
import com.build.shopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

}
