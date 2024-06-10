package code.exam.democrud2table.service;

import code.exam.democrud2table.entity.Category;
import code.exam.democrud2table.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    void removeProduct(Long id);

    void addProduct(Product product);

    Product findProductById(Long id);

    void updateProduct(Long id, Product product);

    Category findCategoryById(Long id);

    List<Category> getCategories();

}
