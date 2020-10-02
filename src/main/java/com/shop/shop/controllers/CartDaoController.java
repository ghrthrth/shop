package com.shop.shop.controllers;

import com.shop.shop.model.Cart;
import com.shop.shop.services.CartDaoServiceImp;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartDaoController {

    @Autowired(required = true)
    @Qualifier(value = "cartDaoServiceImp")
    @Setter
    private CartDaoServiceImp cartDaoServiceImp;
    @RequestMapping(value = "cart", method = RequestMethod.GET)
    public String listCart(final Model model){
        model.addAttribute("Cart", new Cart());
        model.addAttribute("Cart",this.cartDaoServiceImp.listCart());
        return "Cart";
    }
    @RequestMapping(value = "cart/add", method = RequestMethod.POST)
    public String addCart(@ModelAttribute("cart") Cart cart){
        if (cart.getId()==0){
            this.cartDaoServiceImp.addCart(cart);
        } else {
            this.cartDaoServiceImp.updateCart(cart);
        }
        return "redirect:/cart";
    }
    @RequestMapping(value = "/remove/{id}")
    public String removeCart(@PathVariable("id") Cart cart){
        this.cartDaoServiceImp.removeCart(cartDaoServiceImp.getCartById(cart.getId()));
        return "redirect:/cart";
    }
    @RequestMapping(value = "edit{/id}")
    public String editCart(@PathVariable("id") int id, Model model){
        model.addAttribute("listCart", this.cartDaoServiceImp.listCart());
        model.addAttribute("cart",this.cartDaoServiceImp.getCartById(id));
        return "Cart";
    }
    @RequestMapping(value = "cartdara/{id}")
    public String cartData(@PathVariable("id") int id, Model model){
        model.addAttribute("cart", this.cartDaoServiceImp.getCartById(id));
        return "cartdata";
    }
}
