package com.build.shopping.service.order;

import com.build.shopping.dto.OrderDto;
import com.build.shopping.enums.OrderStatus;
import com.build.shopping.exception.ResourceNotFoundException;
import com.build.shopping.model.Cart;
import com.build.shopping.model.Order;
import com.build.shopping.model.OrderItem;
import com.build.shopping.model.Product;
import com.build.shopping.repository.CartRepository;
import com.build.shopping.repository.OrderRespository;
import com.build.shopping.repository.ProductRepository;
import com.build.shopping.service.cart.CartService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderService  implements IOrderService{
    private final OrderRespository orderRespository;
    private final CartService cartService;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;




    @Override
    public Order placeOrder(Long userId) {
        Cart cart = cartService.getCartByUserId(userId);
        Order order = createOrder(cart);
        List<OrderItem> orderItemList = createOrderItems(order, cart);
        order.setOderItems(new HashSet<>(orderItemList));
        order.setTotalAmount(calculateTotalPrice(orderItemList));
        Order savedOrder = orderRespository.save(order);
        cartService.clearCart(cart.getId());
        return savedOrder;
    }


    private Order createOrder(Cart cart){
        Order order = new Order();
        order.setUser(cart.getUser());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }


    private List<OrderItem> createOrderItems(Order order, Cart cart){
        return cart.getItems().stream().map(cartItem -> {
                    Product product = cartItem.getProduct();
                    product.setInventory(product.getInventory() - cartItem.getQuantity());
                    productRepository.save(product);
                    return new OrderItem(
                            order,
                            product,
                            cartItem.getQuantity(),
                            cartItem.getUnitPrice());


                }).toList();
    };

    private BigDecimal calculateTotalPrice(List<OrderItem> orderItem){
        return orderItem
                .stream()
                .map(item -> item.getPrice()
                        .multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    @Override
    public OrderDto getOrder(Long orderId) {
        return orderRespository.findById(orderId)
                .map(this :: convertToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));

    }

    @Override
    public List<OrderDto> getUserOrder(Long userId) {
        List<Order> orders = orderRespository.findByUserId(userId);
        return orders.stream().map(this :: convertToDto).toList();
    }

    private OrderDto convertToDto(Order order){
        return modelMapper.map(order, OrderDto.class);

    }
}
