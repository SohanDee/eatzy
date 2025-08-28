package dev.sohanwijemanna.service.impl;

import dev.sohanwijemanna.model.Cart;
import dev.sohanwijemanna.model.CartItem;
import dev.sohanwijemanna.model.Food;
import dev.sohanwijemanna.model.User;
import dev.sohanwijemanna.repository.CartItemRepository;
import dev.sohanwijemanna.repository.CartRepository;
import dev.sohanwijemanna.request.AddCartItemRequest;
import dev.sohanwijemanna.service.CartService;
import dev.sohanwijemanna.service.FoodService;
import dev.sohanwijemanna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private FoodService foodService;

    @Override
    public CartItem addItemToCart(AddCartItemRequest request, String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Cart cart = cartRepository.findByCustomerId(user.getId());
        Food food = foodService.getFoodById(request.getFoodId());

        for (CartItem cartItem : cart.getItems()){
            if(cartItem.getFood().equals(food)){
                int newQuantity = cartItem.getQuantity() + request.getQuantity();
                return updateItemQuantity(cartItem.getId(), newQuantity);
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setFood(food);
        cartItem.setQuantity(request.getQuantity());
        cartItem.setIngredients(request.getIngredients());
        cartItem.setTotalPrice(request.getQuantity() * food.getPrice());

        CartItem savedCartItem = cartItemRepository.save(cartItem);
        cart.getItems().add(savedCartItem);

        return savedCartItem;
    }

    @Override
    public CartItem updateItemQuantity(Long cartItemId, int quantity) throws Exception {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
        if(cartItemOptional.isEmpty()) throw new Exception("Cart item not found");
        CartItem cartItem = cartItemOptional.get();
        cartItem.setQuantity(quantity);
        cartItem.setTotalPrice(quantity * cartItem.getFood().getPrice());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Cart cart = cartRepository.findByCustomerId(user.getId());
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
        if(cartItemOptional.isEmpty()) throw new Exception("Cart item not found");
        CartItem cartItem = cartItemOptional.get();
        cart.getItems().remove(cartItem);
        return cartRepository.save(cart);
    }

    @Override
    public Long calculateTotal(Cart cart) {
        Long total = 0L;
        for (CartItem cartItem : cart.getItems()) {
            total += cartItem.getTotalPrice();
        }
        return total;
    }

    @Override
    public Cart getCartById(Long cartId) throws Exception {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        if(cartOptional.isEmpty()) throw new Exception("Cart not found");
        return cartOptional.get();
    }

    @Override
    public Cart findCartByUserId(Long userId) throws Exception {
        return cartRepository.findByCustomerId(userId);
    }

    @Override
    public Cart clearCart(Long userId) throws Exception {
        Cart cart = cartRepository.findByCustomerId(userId);
        cart.getItems().clear();
        return cartRepository.save(cart);
    }
}
