package by.skorohodov.shop.controller;

import by.skorohodov.shop.domain.Category;
import by.skorohodov.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
class ShopController {
    private final CategoryService categoryService;

    @Autowired
    public ShopController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    final String home(final Model model) {
        final Iterable<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        return "product";
    }
/*
    @PostMapping(value = "products", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView addProduct(@RequestParam String name,
                            @RequestParam String categoryName) {

        ModelAndView product = new ModelAndView("product");
        try {
            Products products = new Products();
            products.setName(name);
            products.setCategoryName(categoryName);
            product.addObject("message", "Продукт с названием: "
                    + products.getName() + " добавлен.");
        } catch (Exception ex) {
            product.addObject("message", "Failed to add product: " + ex.getMessage());
        }
        product.addObject("products", productService.getProducts());
        return product;
    }*/
}
