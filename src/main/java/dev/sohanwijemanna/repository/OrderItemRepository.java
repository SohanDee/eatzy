package dev.sohanwijemanna.repository;

import dev.sohanwijemanna.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
