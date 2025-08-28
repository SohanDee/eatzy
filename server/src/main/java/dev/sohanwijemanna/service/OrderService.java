package dev.sohanwijemanna.service;

import dev.sohanwijemanna.model.Order;
import dev.sohanwijemanna.model.User;
import dev.sohanwijemanna.request.CreateOrderRequest;

import java.util.List;

public interface OrderService {

    public Order createOrder(CreateOrderRequest request, User user) throws Exception;

    public Order updateOrder(Long orderId, String orderStatus) throws Exception;

    public void cancelOrder(Long orderId) throws Exception;

    public List<Order> getUserOrders(Long userId);

    public List<Order> getRestaurantOrders(Long restaurantId, String orderStatus);

    public Order getOrderById(Long orderId) throws Exception;
}
