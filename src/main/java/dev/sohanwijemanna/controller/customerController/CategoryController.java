package dev.sohanwijemanna.controller.customerController;

import dev.sohanwijemanna.model.Category;
import dev.sohanwijemanna.model.User;
import dev.sohanwijemanna.request.CreateCategoryRequest;
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

    @GetMapping("/restaurant")
    public ResponseEntity<List<Category>> getAllCategories(@RequestHeader("Authorization") String token) throws Exception {
        User user = userService.findUserByJwtToken(token);
        List<Category> categories = categoryService.getCategoriesByRestaurantId(user.getId());
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
