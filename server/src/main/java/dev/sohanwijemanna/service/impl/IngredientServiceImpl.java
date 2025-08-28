package dev.sohanwijemanna.service.impl;

import dev.sohanwijemanna.model.IngredientCategory;
import dev.sohanwijemanna.model.IngredientItem;
import dev.sohanwijemanna.model.Restaurant;
import dev.sohanwijemanna.repository.IngredientCategoryRepository;
import dev.sohanwijemanna.repository.IngredientItemRepository;
import dev.sohanwijemanna.service.IngredientService;
import dev.sohanwijemanna.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    @Autowired
    private IngredientItemRepository ingredientItemRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Override
    public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        IngredientCategory ingredientCategory = new IngredientCategory();
        ingredientCategory.setName(name);
        ingredientCategory.setRestaurant(restaurant);
        return ingredientCategoryRepository.save(ingredientCategory);
    }

    @Override
    public IngredientCategory getIngredientCategoryById(Long id) throws Exception {
        Optional<IngredientCategory> optional = ingredientCategoryRepository.findById(id);
        if(optional.isEmpty()) throw new Exception("Ingredient Category not Found");
        return optional.get();
    }

    @Override
    public List<IngredientCategory> getIngredientCategoriesByRestaurantId(Long restaurantId) throws Exception {
        restaurantService.getRestaurantById(restaurantId);
        return ingredientCategoryRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public IngredientItem createIngredientItem(String name, Long restaurantId, Long ingredientCategoryId) throws Exception {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        IngredientCategory ingredientCategory = getIngredientCategoryById(ingredientCategoryId);

        IngredientItem ingredientItem = new IngredientItem();
        ingredientItem.setName(name);
        ingredientItem.setRestaurant(restaurant);
        ingredientItem.setCategory(ingredientCategory);

        IngredientItem savedIngredient = ingredientItemRepository.save(ingredientItem);
        ingredientCategory.getIngredients().add(savedIngredient);

        return savedIngredient;
    }

    @Override
    public List<IngredientItem> getIngredientItemsByRestaurantId(Long restaurantId) throws Exception {
        restaurantService.getRestaurantById(restaurantId);
        return ingredientItemRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public IngredientItem updateIngredientItemAvailability(Long ingredientItemId) throws Exception {
        Optional<IngredientItem> optional = ingredientItemRepository.findById(ingredientItemId);
        if(optional.isEmpty()) throw new Exception("Ingredient Not Found");
        IngredientItem ingredientItem = optional.get();
        ingredientItem.setInStock(!ingredientItem.isInStock());
        return ingredientItemRepository.save(ingredientItem);
    }
}
