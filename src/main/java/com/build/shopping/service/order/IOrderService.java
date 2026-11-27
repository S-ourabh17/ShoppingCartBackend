package com.build.shopping.service.order;

import com.build.shopping.dto.OrderDto;
import com.build.shopping.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrder(Long userId);
}
