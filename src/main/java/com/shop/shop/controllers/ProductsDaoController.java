package com.shop.shop.controllers;

import com.shop.shop.model.Products;
import com.shop.shop.services.ProductsDaoServiceImp;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ProductsDaoController {

    @Autowired(required = true)
    @Qualifier(value = "cartDaoServiceImp")
    @Setter
    private ProductsDaoServiceImp productsDaoServiceImp;
    @RequestMapping(value = "cart", method = RequestMethod.GET)
    public String listProducts(Model model){
        model.addAttribute("Products", new Products());
        model.addAttribute("Products",this.productsDaoServiceImp.listProducts());
        return "Products";
    }
    @RequestMapping(value = "products/add", method = RequestMethod.POST)
    public String addProducts(@ModelAttribute("products") Products products){
        if (products.getId()==0){
            this.productsDaoServiceImp.addProducts(products);
        } else {
            this.productsDaoServiceImp.updateProducts(products);
        }
        return "redirect:/products";
    }
    @RequestMapping(value = "/remove/{id}")
    public String removeProducts(@PathVariable("id") Products products){
        this.productsDaoServiceImp.removeProducts(productsDaoServiceImp.getProductsById(products.getId()));
        return "redirect:/cart";
    }
    @RequestMapping(value = "edit{/id}")
    public String editCart(@PathVariable("id") int id, Model model){
        model.addAttribute("listProducts", this.productsDaoServiceImp.listProducts());
        model.addAttribute("products",this.productsDaoServiceImp.getProductsById(id));
        return "products";
    }
    @RequestMapping(value = "productsdata/{id}")
    public String cartData(@PathVariable("id") int id, Model model){
        model.addAttribute("cart", this.productsDaoServiceImp.getProductsById(id));
        return "products";
    }
}
