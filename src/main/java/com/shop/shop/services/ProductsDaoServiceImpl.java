package com.shop.shop.services;

import com.shop.shop.model.Products;

import java.util.List;

public interface ProductsDaoServiceImpl {
    void addProducts(Products products);
    void removeProducts(Products products);
    void updateProducts(Products products);
    Products getProductsById(int id);
    List<Products> listProducts();
}
