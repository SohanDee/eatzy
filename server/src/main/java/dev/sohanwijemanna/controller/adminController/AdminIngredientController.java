package dev.sohanwijemanna.controller.adminController;

import dev.sohanwijemanna.model.IngredientCategory;
import dev.sohanwijemanna.model.IngredientItem;
import dev.sohanwijemanna.model.Restaurant;
import dev.sohanwijemanna.model.User;
import dev.sohanwijemanna.request.CreateIngredientCategoryRequest;
import dev.sohanwijemanna.request.CreateIngredientItemRequest;
import dev.sohanwijemanna.service.IngredientService;
import dev.sohanwijemanna.service.RestaurantService;
import dev.sohanwijemanna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ingredient")
public class AdminIngredientController {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/category")
    public ResponseEntity<IngredientCategory> createIngredientCategory(
            @RequestBody CreateIngredientCategoryRequest request,
            @RequestHeader("Authorization") String token) throws Exception {
        User user = userService.findUserByJwtToken(token);
        Restaurant restaurant = restaurantService.getRestaurantByUserId(user.getId());
        IngredientCategory ingredientCategory = ingredientService.createIngredientCategory(request.getName(), restaurant.getId());
        return new ResponseEntity<>(ingredientCategory, HttpStatus.CREATED);
    }

    @PostMapping("/item")
    public ResponseEntity<IngredientItem> createIngredientItem(
            @RequestBody CreateIngredientItemRequest request,
            @RequestHeader("Authorization") String token) throws Exception {
        User user = userService.findUserByJwtToken(token);
        Restaurant restaurant = restaurantService.getRestaurantByUserId(user.getId());
        IngredientItem ingredientItem = ingredientService.createIngredientItem(request.getName(), restaurant.getId(), request.getIngredientCategoryId());
        return new ResponseEntity<>(ingredientItem, HttpStatus.CREATED);
    }

    @GetMapping("/category")
    public ResponseEntity<List<IngredientCategory>> getIngredientCategories(@RequestHeader("Authorization") String token) throws Exception {
        User user = userService.findUserByJwtToken(token);
        Restaurant restaurant = restaurantService.getRestaurantByUserId(user.getId());
        List<IngredientCategory> ingredientCategories = ingredientService.getIngredientCategoriesByRestaurantId(restaurant.getId());
        return new ResponseEntity<>(ingredientCategories, HttpStatus.OK);
    }

    @GetMapping("/item")
    public ResponseEntity<List<IngredientItem>> getIngredientItems(@RequestHeader("Authorization") String token) throws Exception {
        User user = userService.findUserByJwtToken(token);
        Restaurant restaurant = restaurantService.getRestaurantByUserId(user.getId());
        List<IngredientItem> ingredientItems = ingredientService.getIngredientItemsByRestaurantId(restaurant.getId());
        return new ResponseEntity<>(ingredientItems, HttpStatus.OK);
    }
}
