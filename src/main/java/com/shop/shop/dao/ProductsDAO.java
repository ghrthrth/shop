package com.shop.shop.dao;

import java.util.List;

public interface ProductsDAO{
    public void addProducts(Products products);
    public List<Products> listProducts();
}
