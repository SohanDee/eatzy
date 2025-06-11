package dev.sohanwijemanna.repository;

import dev.sohanwijemanna.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, Long> {
}
