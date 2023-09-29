package st.nvt.managerrestaurant.service;

import org.springframework.data.domain.Page;
import st.nvt.managerrestaurant.model.service.Food;

import java.util.Optional;

public interface FoodService {
    Page<Food> listFoods(int page, int size);
    void saveOrUpdate(Food food);

    Optional<Food> findById(Long id);
}
