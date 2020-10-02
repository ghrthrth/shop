package com.shop.shop.services;


import com.shop.shop.model.Cart;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartDaoServiceImp implements CartDaoService {
    @Getter
    @Setter
    private CartDaoService cartDaoSevice;

    @Override
    @Transactional
    public void addCart(Cart cart) {
        this.cartDaoSevice.addCart(cart);
    }

    @Override
    @Transactional
    public void removeCart(Cart cart) {
        this.cartDaoSevice.removeCart(cart);
    }

    @Override
    @Transactional
    public void updateCart(Cart cart) {
        this.cartDaoSevice.updateCart(cart);
    }

    @Override
    @Transactional
    public Cart getCartById(int id) {
        return this.cartDaoSevice.getCartById(id);
    }

    @Override
    @Transactional
    public List<Cart> listCart() {
        return this.cartDaoSevice.listCart();
    }
}
