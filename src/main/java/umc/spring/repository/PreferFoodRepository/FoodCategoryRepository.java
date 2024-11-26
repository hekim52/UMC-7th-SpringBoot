package umc.spring.repository.PreferFoodRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
