package by.skorohodov.shop.repository;

import by.skorohodov.shop.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findById(final int id);
}
