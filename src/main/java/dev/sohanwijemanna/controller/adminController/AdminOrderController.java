package dev.sohanwijemanna.controller.adminController;

import dev.sohanwijemanna.model.Order;
import dev.sohanwijemanna.service.OrderService;
import dev.sohanwijemanna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders/restaurant/{id}")
    public ResponseEntity<List<Order>> getRestaurantOrders(
            @PathVariable Long id,
            @RequestParam(required = false) String order_status){
        List<Order> orders = orderService.getRestaurantOrders(id, order_status);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping("/order/{id}/{order_status}")
    public ResponseEntity<Order> updateOrder(
            @PathVariable Long id,
            @PathVariable String order_status) throws Exception {
        Order order = orderService.updateOrder(id, order_status);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
