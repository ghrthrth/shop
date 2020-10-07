package by.skorohodov.shop.service;

import by.skorohodov.shop.domain.Product;
import by.skorohodov.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(final Product product) {
        productRepository.save(product);
        return product;
    }

    public Product getProductById(final int id){
        return productRepository.findById(id);
    }
}
