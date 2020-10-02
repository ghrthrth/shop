package com.shop.shop.services;

import com.shop.shop.model.Cart;

import java.util.List;

public interface CartDaoService {
     void addCart(Cart cart);
     void removeCart(Cart cart);
     void updateCart(Cart cart);
     Cart getCartById(int id);
     List<Cart> listCart();
}
