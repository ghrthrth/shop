package com.shop.shop;

import com.shop.shop.dao.Products;
import com.shop.shop.service.ProductsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
		Products products = new Products(345,"34535",5354);
		ProductsService.addProducts(products);
	}



}
