package dev.sohanwijemanna.repository;

import dev.sohanwijemanna.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findByOwnerId(Long ownerId);

    @Query("SELECT restaurant FROM Restaurant restaurant WHERE lower(restaurant.name) LIKE lower(concat('%', :query, '%'))" +
            "OR lower(restaurant.cuisineType) LIKE lower(concat('%', :query, '%'))")
    List<Restaurant> findBySearchQuery(String query);
}
