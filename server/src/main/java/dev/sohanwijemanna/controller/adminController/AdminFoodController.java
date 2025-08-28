package dev.sohanwijemanna.controller.adminController;

import dev.sohanwijemanna.model.Food;
import dev.sohanwijemanna.model.Restaurant;
import dev.sohanwijemanna.request.AddFoodRequest;
import dev.sohanwijemanna.response.MessageResponse;
import dev.sohanwijemanna.service.FoodService;
import dev.sohanwijemanna.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Food> addFood(@RequestBody AddFoodRequest request) throws Exception {
        Restaurant restaurant = restaurantService.getRestaurantById(request.getRestaurantId());
        Food food = foodService.addFood(request, request.getCategory(), restaurant);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id) throws Exception {
        foodService.deleteFood(id);
        MessageResponse response = new MessageResponse();
        response.setMessage("Food deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFoodAvailability(@PathVariable Long id) throws Exception {
        Food food = foodService.updateAvailability(id);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }
}
