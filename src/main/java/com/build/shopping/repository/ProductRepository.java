package com.build.shopping.repository;
import java.util.List;

import com.build.shopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface ProductRepository extends JpaRepository<Product,Long> {
}
