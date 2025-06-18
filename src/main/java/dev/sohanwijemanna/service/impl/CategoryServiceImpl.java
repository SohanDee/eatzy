package dev.sohanwijemanna.service.impl;

import dev.sohanwijemanna.model.Category;
import dev.sohanwijemanna.model.Restaurant;
import dev.sohanwijemanna.repository.CategoryRepository;
import dev.sohanwijemanna.repository.RestaurantRepository;
import dev.sohanwijemanna.service.CategoryService;
import dev.sohanwijemanna.service.FoodService;
import dev.sohanwijemanna.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Override
    public Category createCategory(String name, Long userId) throws Exception {
        Restaurant restaurant = restaurantService.getRestaurantByUserId(userId);
        Category category = new Category();
        category.setName(name);
        category.setRestaurant(restaurant);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategoriesByRestaurantId(Long userId) throws Exception {
        Restaurant restaurant = restaurantService.getRestaurantByUserId(userId);
        return categoryRepository.findByRestaurantId(restaurant.getId());
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) throw new Exception("Category not found");
        return category.get();
    }
}
