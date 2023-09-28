package st.nvt.managerrestaurant.service;

import org.springframework.data.domain.Page;
import st.nvt.managerrestaurant.model.service.Food;

import java.util.List;

public interface FoodService {
    Page<Food> listFoods(int page, int size);
}
