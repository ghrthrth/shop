package by.skorohodov.shop.controller;

import by.skorohodov.shop.domain.Category;
import by.skorohodov.shop.domain.Product;
import by.skorohodov.shop.service.CategoryService;
import by.skorohodov.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
class ShopController {

    private static final List<Product> productList = new ArrayList<>();
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public ShopController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    private static void getCategories(final Model model, final CategoryService categoryService) {
        final Iterable<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
    }

    @GetMapping
    final String home(final Model model) {
        getCategories(model, categoryService);
        return "product";
    }

    @PostMapping
    public String addToCart(final Model model, final @RequestParam int id) {
        final Product product = productService.getProductById(id);
        if (productList.isEmpty()) {
            productList.add(product);
        } else {
            for (int i = 0; i <= productList.size(); i++) {
                if (productList.get(i).getId() != product.getId()) {
                    productList.add(product);
                    System.out.println("ADDED!");
                } else {
                    System.out.println("NOT ADDED");
                }
            }
        }
        getCategories(model, categoryService);
        return "product";
    }

    @GetMapping("/add")
    final String showProducts(final Model model) {
        getCategories(model, categoryService);
        return "add";
    }

    @PostMapping("/add")
    final String addProduct(final Model model,
                            final @RequestParam String name,
                            final @RequestParam int price,
                            final @RequestParam int count,
                            final @RequestParam int categoryId) {
        try {
            final Product product = new Product()
                    .setName(name)
                    .setPrice(price)
                    .setCount(count)
                    .setCategoryId(categoryId);
            productService.addProduct(product);
            model.addAttribute("message", "Продукт с именем : "
                    + product.getName() + " успешно добавлен");
            getCategories(model, categoryService);
        } catch (final Exception ex) {
            getCategories(model, categoryService);
            model.addAttribute("message", "Добавление продукта с именем : "
                    + ex.getMessage() + " заверщилось ошибкой");
        }
        return "add";
    }

    @GetMapping("/cart")
    public String showCart(final Model model) {
        return "cart";
    }
}
