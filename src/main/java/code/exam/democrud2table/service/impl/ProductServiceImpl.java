package code.exam.democrud2table.service.impl;

import code.exam.democrud2table.entity.Category;
import code.exam.democrud2table.entity.Product;
import code.exam.democrud2table.repository.CategoryRepository;
import code.exam.democrud2table.repository.ProductRepository;
import code.exam.democrud2table.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void updateProduct(Long id, Product product) {
        Product newProduct =  findProductById(id);
        newProduct.setCode(product.getCode());
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setDescription(product.getDescription());
        newProduct.setCategoryId(product.getCategoryId());
        productRepository.save(newProduct);
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
