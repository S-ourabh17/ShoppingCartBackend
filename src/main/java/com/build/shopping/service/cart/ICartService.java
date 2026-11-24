package com.build.shopping.service.cart;

import com.build.shopping.model.Cart;
import com.build.shopping.model.User;

import java.math.BigDecimal;

public interface  ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
    Long initializeCart();
    Cart getCartByUserId(Long userId);
}
