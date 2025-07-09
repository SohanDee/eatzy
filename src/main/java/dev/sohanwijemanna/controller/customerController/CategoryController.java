package dev.sohanwijemanna.controller.customerController;

import dev.sohanwijemanna.model.Category;
import dev.sohanwijemanna.service.CategoryService;
import dev.sohanwijemanna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    private UserService userService;

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Category>> getAllCategories(@PathVariable Long restaurantId) throws Exception {
        List<Category> categories = categoryService.getCategoriesByRestaurantId(restaurantId);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
