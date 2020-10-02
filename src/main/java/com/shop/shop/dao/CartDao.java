package com.shop.shop.dao;

import com.shop.shop.model.Cart;

import java.util.List;

public interface CartDao {
    List<Cart> listCart();
    void addCart(Cart cart);
    void updateCart(Cart cart);
    public void removeCart(Cart cart);
    public void getCartById(int id);
}
