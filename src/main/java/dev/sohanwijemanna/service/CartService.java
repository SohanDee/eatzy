package dev.sohanwijemanna.service;

import dev.sohanwijemanna.model.Cart;
import dev.sohanwijemanna.model.CartItem;
import dev.sohanwijemanna.model.User;
import dev.sohanwijemanna.request.AddCartItemRequest;

public interface CartService {

    public CartItem addItemToCart(AddCartItemRequest request, String jwt) throws Exception;

    public CartItem updateItemQuantity(Long cartItemId, int quantity) throws Exception;

    public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception;

    public Long calculateTotal(Cart cart);

    public Cart getCartById(Long cartId) throws Exception;

    public Cart findCartByUserId(String jwt) throws Exception;

    public Cart clearCart(String jwt) throws Exception;
}
