package st.nvt.managerrestaurant.service;

import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.model.service.Images;
import st.nvt.managerrestaurant.model.service.Restaurant;

import java.util.List;
import java.util.Optional;


public interface ImagesService {
    Images  saveOrUpdate(Images image);
    List<Images> findByFood(Food food);

    List<Images> findByRestaurant(Restaurant restaurant);

    Images findTop1ByFood(Long id);

    List<Images> findAll();

    void delete(Images images);
}
