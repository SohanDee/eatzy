package dev.sohanwijemanna.service.impl;

import dev.sohanwijemanna.model.Category;
import dev.sohanwijemanna.model.Food;
import dev.sohanwijemanna.model.Restaurant;
import dev.sohanwijemanna.repository.FoodRepository;
import dev.sohanwijemanna.request.AddFoodRequest;
import dev.sohanwijemanna.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Food addFood(AddFoodRequest request, Category category, Restaurant restaurant){
        Food food = new Food();
        food.setName(request.getName());
        food.setCategory(category);
        food.setRestaurant(restaurant);
        food.setDescription(request.getDescription());
        food.setImages(request.getImages());
        food.setPrice(request.getPrice());
        food.setIngredients(request.getIngredients());
        food.setSeasonal(request.isSeasonal());
        food.setVegetarian(request.isVegetarian());
//        Food savedFood = foodRepository.save(food);
//        restaurant.getFoods().add(savedFood);
//        return savedFood;
        return foodRepository.save(food);
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {
//        Food food = getFoodById(foodId);
//        food.setRestaurant(null);
//        foodRepository.save(food);
        foodRepository.deleteById(foodId);
    }

    @Override
    public List<Food> getRestaurantFoods(Long restaurantId,
                                         boolean isVegetarian,
                                         boolean isNonVeg,
                                         boolean isSeasonal,
                                         String foodCategory){

        List<Food> foods = foodRepository.findByRestaurantId(restaurantId);
        if (isVegetarian) foods = filterByVegetarian(foods);
        if (isNonVeg) foods = filterByNonVeg(foods);
        if (isSeasonal) foods = filterBySeasonal(foods);
        if (foodCategory != null && !foodCategory.isBlank()) foods = filterByCategory(foods, foodCategory);
        return foods;
    }


    private List<Food> filterByVegetarian(List<Food> foods) {
        return foods.stream().filter(Food::isVegetarian).collect(Collectors.toList());
    }

    private List<Food> filterByNonVeg(List<Food> foods) {
        return foods.stream().filter(food -> !food.isVegetarian()).collect(Collectors.toList());
    }

    private List<Food> filterBySeasonal(List<Food> foods) {
        return foods.stream().filter(Food::isSeasonal).collect(Collectors.toList());
    }

    private List<Food> filterByCategory(List<Food> foods, String foodCategory) {
        return foods.stream().filter(food -> food.getCategory().getName().equals(foodCategory)).collect(Collectors.toList());
    }

    @Override
    public List<Food> searchFoods(String keyword){
        return foodRepository.searchFood(keyword);
    }

    @Override
    public Food getFoodById(Long foodId) throws Exception {
        Optional<Food> food = foodRepository.findById(foodId);
        if (food.isEmpty()) throw new Exception("No food found with id " + foodId);
        return food.get();
    }

    @Override
    public Food updateAvailability(Long foodId) throws Exception {
        Food food = getFoodById(foodId);
        food.setAvailable(!food.isAvailable());
        return foodRepository.save(food);
    }
}
