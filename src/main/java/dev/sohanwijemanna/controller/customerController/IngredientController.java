package dev.sohanwijemanna.controller.customerController;

import dev.sohanwijemanna.model.IngredientCategory;
import dev.sohanwijemanna.model.IngredientItem;
import dev.sohanwijemanna.model.Restaurant;
import dev.sohanwijemanna.model.User;
import dev.sohanwijemanna.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/category/restaurant/{restaurantId}")
    public ResponseEntity<List<IngredientCategory>> getIngredientCategories(@PathVariable Long restaurantId) throws Exception {
        List<IngredientCategory> ingredientCategories = ingredientService.getIngredientCategoriesByRestaurantId(restaurantId);
        return new ResponseEntity<>(ingredientCategories, HttpStatus.OK);
    }

    @GetMapping("/item/restaurant/{restaurantId}")
    public ResponseEntity<List<IngredientItem>> getIngredientItems(@PathVariable Long restaurantId) throws Exception {
        List<IngredientItem> ingredientItems = ingredientService.getIngredientItemsByRestaurantId(restaurantId);
        return new ResponseEntity<>(ingredientItems, HttpStatus.OK);
    }
}
