package dev.sohanwijemanna.service.impl;

import dev.sohanwijemanna.dto.RestaurantDto;
import dev.sohanwijemanna.model.Restaurant;
import dev.sohanwijemanna.model.User;
import dev.sohanwijemanna.repository.RestaurantRepository;
import dev.sohanwijemanna.request.CreateRestaurantRequest;
import dev.sohanwijemanna.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest request, User user) throws Exception {
        return null;
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest request) throws Exception {
        return null;
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {

    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) throws Exception {
        return null;
    }

    @Override
    public List<Restaurant> getAllRestaurants() throws Exception {
        return List.of();
    }

    @Override
    public List<Restaurant> searchRestaurants(String search) throws Exception {
        return List.of();
    }

    @Override
    public Restaurant getRestaurantByUserId(Long userId) throws Exception {
        return null;
    }

    @Override
    public RestaurantDto addToFavourites(Long restaurantId, Long userId) throws Exception {
        return null;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long Id) throws Exception {
        return null;
    }
}
