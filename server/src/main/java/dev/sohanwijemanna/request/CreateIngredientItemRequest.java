package dev.sohanwijemanna.request;

import lombok.Data;

@Data
public class CreateIngredientItemRequest {
    String name;
    Long ingredientCategoryId;
}
