package dev.sohanwijemanna.service;

import dev.sohanwijemanna.model.IngredientCategory;
import dev.sohanwijemanna.model.IngredientItem;

import java.util.List;

public interface IngredientService {

    public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception;

    public IngredientCategory getIngredientCategoryById(Long id) throws Exception;

    public List<IngredientCategory> getIngredientCategoriesByRestaurantId(Long restaurantId) throws Exception;

    public IngredientItem createIngredientItem(String name, Long restaurantId, Long ingredientCategoryId) throws Exception;

    public List<IngredientItem> getIngredientItemsByRestaurantId(Long restaurantId) throws Exception;

    public IngredientItem updateIngredientItemAvailability(Long ingredientItemId) throws Exception;
}
