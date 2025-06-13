package dev.sohanwijemanna.controller;

import dev.sohanwijemanna.model.Food;
import dev.sohanwijemanna.service.FoodService;
import dev.sohanwijemanna.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String keyword) {
        List<Food> foods = foodService.searchFoods(keyword);
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getRestaurantFoods(
            @RequestParam boolean vegetarian,
            @RequestParam boolean nonVeg,
            @RequestParam boolean seasonal,
            @RequestParam(required = false) String category,
            @PathVariable Long restaurantId) {
        List<Food> foods = foodService.getRestaurantFoods(restaurantId, vegetarian, nonVeg, seasonal, category);
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }
}
