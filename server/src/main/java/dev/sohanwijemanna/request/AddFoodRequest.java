package dev.sohanwijemanna.request;

import dev.sohanwijemanna.model.Category;
import dev.sohanwijemanna.model.IngredientItem;
import lombok.Data;

import java.util.List;

@Data
public class AddFoodRequest {
    private String name;
    private String description;
    private Long price;
    private Category category;
    private List<String> images;
    private Long restaurantId;
    private boolean vegetarian;
    private boolean seasonal;
    private List<IngredientItem> ingredients;
}
