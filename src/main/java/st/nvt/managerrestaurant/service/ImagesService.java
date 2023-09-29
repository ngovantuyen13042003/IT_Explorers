package st.nvt.managerrestaurant.service;

import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.model.service.Images;

import java.util.List;


public interface ImagesService {
    Images  saveOrUpdate(Images image);

    List<Images> findByFood(Food food);

    List<Images> findAll();
}
