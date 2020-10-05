package com.shop.shop.service;


import com.shop.shop.dao.Products;
import com.shop.shop.dao.ProductsDaoImpl;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ProductsService {
    private final static ProductsDaoImpl productsDaoImp = new ProductsDaoImpl();
    public static void addProducts(Products products){
        ProductsDaoImpl.addProducts(products);
    }
    public List<Products> listProducts() {
        return productsDaoImp.listProducts();
    }
}


