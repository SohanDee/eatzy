package dev.sohanwijemanna.service.impl;

import dev.sohanwijemanna.model.*;
import dev.sohanwijemanna.repository.AddressRepository;
import dev.sohanwijemanna.repository.OrderItemRepository;
import dev.sohanwijemanna.repository.OrderRepository;
import dev.sohanwijemanna.request.CreateOrderRequest;
import dev.sohanwijemanna.service.CartService;
import dev.sohanwijemanna.service.OrderService;
import dev.sohanwijemanna.service.RestaurantService;
import dev.sohanwijemanna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @Override
    public Order createOrder(CreateOrderRequest request, User user) throws Exception {
        Address address = request.getDeliveryAddress();
        Address savedAddress = addressRepository.save(address);
        if(!user.getAddresses().contains(address)) {
            user.getAddresses().add(address);
        }

        Restaurant restaurant = restaurantService.getRestaurantById(request.getRestaurantId());

        Order order = new Order();
        order.setCustomer(user);
        order.setRestaurant(restaurant);
        order.setDeliveryAddress(address);
        order.setCreatedAt(new Date());
        order.setOrderStatus("PENDING");

        Cart cart = cartService.findCartByUserId(user.getId());
        List<OrderItem> orderItems = new ArrayList<>();
        for(CartItem cartItem : cart.getItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setFood(cartItem.getFood());
            orderItem.setIngredients(cartItem.getIngredients());
            orderItem.setTotalPrice(cartItem.getTotalPrice());

            OrderItem savedOrderItem = orderItemRepository.save(orderItem);
            orderItems.add(savedOrderItem);
        }

        order.setItems(orderItems);
        order.setTotalPrice(cart.getTotal());

        Order savedOrder = orderRepository.save(order);
        restaurant.getOrders().add(savedOrder);
        return savedOrder;
    }

    @Override
    public Order updateOrder(Long orderId, String orderStatus) throws Exception {
        Order order = getOrderById(orderId);
        if(orderStatus.equals("OUT_FOR_DELIVERY") ||
                orderStatus.equals("DELIVERED") ||
                orderStatus.equals("COMPLETED") ||
                orderStatus.equals("PENDING")) {
            order.setOrderStatus(orderStatus);
            orderRepository.save(order);
        }
        throw new Exception("Please select a valid order status");
    }

    @Override
    public void cancelOrder(Long orderId) throws Exception {
        Order order = getOrderById(orderId);
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByCustomerId(userId);
    }

    @Override
    public List<Order> getRestaurantOrders(Long restaurantId, String orderStatus) {
        List<Order> orders = orderRepository.findByRestaurantId(restaurantId);
        if(orderStatus!=null){
            orders = orders.stream().filter(
                    order -> order.getOrderStatus().equals(orderStatus)
            ).toList();
        }
        return orders;
    }

    @Override
    public Order getOrderById(Long orderId) throws Exception {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if(orderOptional.isEmpty()) throw new Exception("Order not found");
        return orderOptional.get();
    }
}
