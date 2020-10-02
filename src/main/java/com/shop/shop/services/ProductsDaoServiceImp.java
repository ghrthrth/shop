package com.shop.shop.services;

import com.shop.shop.model.Products;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductsDaoServiceImp implements ProductsDaoServiceImpl{
    @Getter
    @Setter
    private ProductsDaoServiceImpl productsDaoService;
    @Transactional
    @Override
    public void addProducts(Products products) {
        this.productsDaoService.addProducts(products);
    }

    @Override
    @Transactional
    public void removeProducts(Products products) {
        this.productsDaoService.removeProducts(products);
    }

    @Override
    @Transactional
    public void updateProducts(Products products) {
        this.productsDaoService.updateProducts(products);
    }

    @Override
    @Transactional
    public Products getProductsById(int id) {
        return this.productsDaoService.getProductsById(id);
    }

    @Override
    @Transactional
    public List<Products> listProducts() {
        return this.productsDaoService.listProducts();
    }
}
