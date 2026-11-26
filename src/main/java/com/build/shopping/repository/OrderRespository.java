package com.build.shopping.repository;

import com.build.shopping.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRespository extends JpaRepository<Order,Long> {
    List<Order> findByUserId(Long id);
}
