package dev.sohanwijemanna.service;

import dev.sohanwijemanna.dto.RestaurantDto;
import dev.sohanwijemanna.model.Restaurant;
import dev.sohanwijemanna.model.User;
import dev.sohanwijemanna.request.CreateRestaurantRequest;

import java.util.List;

public interface RestaurantService {

    public Restaurant createRestaurant(CreateRestaurantRequest request, User user);

    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest request) throws Exception;

    public void deleteRestaurant(Long restaurantId) throws Exception;

    public Restaurant getRestaurantById(Long restaurantId) throws Exception;

    public List<Restaurant> getAllRestaurants() throws Exception;

    public List<Restaurant> searchRestaurants(String keyword) throws Exception;

    public Restaurant getRestaurantByUserId(Long userId) throws Exception;

    public RestaurantDto addToFavourites(Long restaurantId, User user) throws Exception;

    public Restaurant updateRestaurantStatus(Long Id) throws Exception;
}
