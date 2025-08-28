package dev.sohanwijemanna.repository;

import dev.sohanwijemanna.model.Cart;
import dev.sohanwijemanna.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
