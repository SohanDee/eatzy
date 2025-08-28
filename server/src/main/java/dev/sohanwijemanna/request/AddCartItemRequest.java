package dev.sohanwijemanna.request;

import dev.sohanwijemanna.model.CartItem;
import dev.sohanwijemanna.model.Food;
import dev.sohanwijemanna.model.IngredientItem;
import lombok.Data;

import java.util.List;

@Data
public class AddCartItemRequest {

    private Long foodId;
    private int quantity;
    private List<String> ingredients;
}
