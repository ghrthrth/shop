package com.shop.shop.dao;

import com.shop.shop.model.Products;

import java.util.List;

public interface ProductsDao {
    public void addProducts(Products products);
    public void removeProducts(Products products);
    public void updateProducts(Products products);
    public List<Products> listProducts();
    public void getProductsById(int id);

}
