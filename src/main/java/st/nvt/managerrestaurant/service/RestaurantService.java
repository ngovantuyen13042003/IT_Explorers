package st.nvt.managerrestaurant.service;

import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.model.service.Restaurant;
import st.nvt.managerrestaurant.model.service.TypeRestaurant;

import java.util.List;

public interface RestaurantService {


    Restaurant findById(Long id);

    public void saveOrUpdate(Restaurant restaurant);

    public Boolean existById(Long id);

}
