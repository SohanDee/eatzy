package dev.sohanwijemanna.controller.customerController;

import dev.sohanwijemanna.model.Cart;
import dev.sohanwijemanna.model.CartItem;
import dev.sohanwijemanna.model.User;
import dev.sohanwijemanna.request.AddCartItemRequest;
import dev.sohanwijemanna.request.UpdateCartItemRequest;
import dev.sohanwijemanna.service.CartService;
import dev.sohanwijemanna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @PutMapping("/card/add")
    public ResponseEntity<CartItem> addItemToCart(
            @RequestBody AddCartItemRequest request,
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        CartItem cartItem = cartService.addItemToCart(request, jwt);
        return new ResponseEntity<>(cartItem, HttpStatus.CREATED);
    }

    @PutMapping("/cart-item/update")
    public ResponseEntity<CartItem> updateItemQuantity(
            @RequestBody UpdateCartItemRequest request) throws Exception{
        CartItem cartItem = cartService.updateItemQuantity(request.getCartItemId(), request.getQuantity());
        return new ResponseEntity<>(cartItem, HttpStatus.OK);
    }

    @DeleteMapping("/cart-item/{id}/remove")
    public ResponseEntity<Cart> removeItemFromCart(
            @PathVariable Long id,
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        Cart cart = cartService.removeItemFromCart(id, jwt);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/cart/clear")
    public ResponseEntity<Cart> clearCart(@RequestHeader String jwt) throws Exception {
        User user = userService.findUserByEmail(jwt);
        Cart cart = cartService.clearCart(user.getId());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/cart")
    public ResponseEntity<Cart> getCartByUserId(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByEmail(jwt);
        Cart cart = cartService.findCartByUserId(user.getId());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}
