package code.exam.democrud2table.repository;

import code.exam.democrud2table.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
