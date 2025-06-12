package dev.sohanwijemanna.service.impl;

import dev.sohanwijemanna.dto.RestaurantDto;
import dev.sohanwijemanna.model.Address;
import dev.sohanwijemanna.model.Restaurant;
import dev.sohanwijemanna.model.User;
import dev.sohanwijemanna.repository.AddressRepository;
import dev.sohanwijemanna.repository.RestaurantRepository;
import dev.sohanwijemanna.repository.UserRepository;
import dev.sohanwijemanna.request.CreateRestaurantRequest;
import dev.sohanwijemanna.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest request, User user){
        Address address = addressRepository.save(request.getAddress());

        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getName());
        restaurant.setAddress(address);
        restaurant.setCuisineType(request.getCuisineType());
        restaurant.setDescription(request.getDescription());
        restaurant.setImages(request.getImages());
        restaurant.setOpeningHours(request.getOpeningHours());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setOwner(user);

        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest request) throws Exception {
        Restaurant restaurant = getRestaurantById(restaurantId);
        if(request.getCuisineType() != null) restaurant.setCuisineType(request.getCuisineType());
        if(request.getDescription() != null) restaurant.setDescription(request.getDescription());
        if(request.getName() != null) restaurant.setName(request.getName());
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {
        Restaurant restaurant = getRestaurantById(restaurantId);
        restaurantRepository.delete(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) throws Exception {
        Optional<Restaurant> opt = restaurantRepository.findById(restaurantId);
        if(opt.isEmpty()) throw new Exception("Restaurant with id " + restaurantId + " not found");
        return opt.get();
    }

    @Override
    public List<Restaurant> getAllRestaurants() throws Exception {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurants(String keyword) throws Exception {
        return restaurantRepository.findBySearchQuery(keyword);
    }

    @Override
    public Restaurant getRestaurantByUserId(Long userId) throws Exception {
        Restaurant restaurant = restaurantRepository.findByOwnerId(userId);
        if(restaurant == null) throw new Exception("Restaurant with owner id " + userId + " not found");
        return restaurant;
    }

    @Override
    public RestaurantDto addToFavourites(Long restaurantId, User user) throws Exception {
        Restaurant restaurant = getRestaurantById(restaurantId);

        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setId(restaurant.getId());
        restaurantDto.setName(restaurant.getName());
        restaurantDto.setDescription(restaurant.getDescription());
        restaurantDto.setImages(restaurant.getImages());

        if(user.getFavourites().contains(restaurantDto)) user.getFavourites().remove(restaurantDto);
        else user.getFavourites().add(restaurantDto);

        userRepository.save(user);
        return restaurantDto;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long restaurantId) throws Exception {
        Restaurant restaurant = getRestaurantById(restaurantId);
        restaurant.setOpen(!restaurant.isOpen());
        return restaurantRepository.save(restaurant);
    }
}
