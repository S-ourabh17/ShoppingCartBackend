package com.build.shopping.repository;

import com.build.shopping.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    void  deleteAllByCartId(Long id);

}
