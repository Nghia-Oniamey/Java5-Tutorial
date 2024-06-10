package code.exam.democrud2table.repository;

import code.exam.democrud2table.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
