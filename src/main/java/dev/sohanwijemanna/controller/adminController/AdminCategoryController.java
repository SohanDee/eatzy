package dev.sohanwijemanna.controller.adminController;

import dev.sohanwijemanna.model.Category;
import dev.sohanwijemanna.model.Restaurant;
import dev.sohanwijemanna.model.User;
import dev.sohanwijemanna.request.CreateCategoryRequest;
import dev.sohanwijemanna.service.CategoryService;
import dev.sohanwijemanna.service.RestaurantService;
import dev.sohanwijemanna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
public class AdminCategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Category> createCategory(
            @RequestBody CreateCategoryRequest request,
            @RequestHeader("Authorization") String token) throws Exception {
        System.out.println(request.getName());
        User user = userService.findUserByJwtToken(token);
        Category createdCategory = categoryService.createCategory(request.getName(), user.getId());
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant")
    public ResponseEntity<List<Category>> getAllCategories(@RequestHeader("Authorization") String token) throws Exception {
        User user = userService.findUserByJwtToken(token);
        Restaurant restaurant = restaurantService.getRestaurantByUserId(user.getId());
        List<Category> categories = categoryService.getCategoriesByRestaurantId(restaurant.getId());
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
