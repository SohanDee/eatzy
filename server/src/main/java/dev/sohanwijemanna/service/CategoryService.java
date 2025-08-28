package dev.sohanwijemanna.service;

import dev.sohanwijemanna.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    public Category createCategory(String name, Long userId) throws Exception;

    public List<Category> getCategoriesByRestaurantId(Long restaurantId) throws Exception;

    public Category getCategoryById(Long id) throws Exception;
}
