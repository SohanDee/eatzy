package dev.sohanwijemanna.service;

import dev.sohanwijemanna.model.Category;
import dev.sohanwijemanna.model.Food;
import dev.sohanwijemanna.model.Restaurant;
import dev.sohanwijemanna.request.AddFoodRequest;

import java.util.List;

public interface FoodService {

    public Food addFood(
            AddFoodRequest addFoodRequest,
            Category category,
            Restaurant restaurant);

    public void deleteFood(Long foodId) throws Exception;

    public List<Food> getRestaurantFoods(Long restaurantId,
                                         boolean vegetarian,
                                         boolean isNonVeg,
                                         boolean seasonal,
                                         String foodCategory);

    public List<Food> searchFoods(String keyword);

    public Food getFoodById(Long foodId) throws Exception;

    public Food updateAvailability(Long foodId) throws Exception;
}
