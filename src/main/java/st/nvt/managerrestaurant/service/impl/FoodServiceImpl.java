package st.nvt.managerrestaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.repository.FoodRepository;
import st.nvt.managerrestaurant.service.FoodService;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Override
    public List<Food> listFoods() {
        return foodRepository.findAll();
    }
}
