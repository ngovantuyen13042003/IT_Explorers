package st.nvt.managerrestaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.repository.FoodRepository;
import st.nvt.managerrestaurant.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Page<Food> listFoods(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return foodRepository.findAll(pageable);
    }
}
