package st.nvt.managerrestaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import st.nvt.managerrestaurant.model.service.Restaurant;
import st.nvt.managerrestaurant.model.service.TypeRestaurant;
import st.nvt.managerrestaurant.repository.IRestaurantRepository;
import st.nvt.managerrestaurant.service.RestaurantService;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private IRestaurantRepository repository;

    @Override
    public Restaurant findById(Long id) {
        return repository.getById(id);
    }

    @Override
    public void saveOrUpdate(Restaurant restaurant) {
        // Kiểm tra xem nhà hàng đã tồn tại trong cơ sở dữ liệu chưa
        if (restaurant.getId() != null) {
            // Nhà hàng đã tồn tại, thực hiện cập nhật
            Restaurant existingRestaurant = repository.findById(restaurant.getId()).orElse(null);
            if (existingRestaurant != null) {
                existingRestaurant.setName(restaurant.getName());
                existingRestaurant.setAddress(restaurant.getAddress());
                existingRestaurant.setEmail(restaurant.getEmail());
                existingRestaurant.setCountry(restaurant.getCountry());
                existingRestaurant.setPhoneNumber(restaurant.getPhoneNumber());
                existingRestaurant.setTypeRestaurant(restaurant.getTypeRestaurant());
                existingRestaurant.setImages(restaurant.getImages());

                repository.save(existingRestaurant);
            }
        } else {
            repository.save(restaurant);
        }
    }

    @Override
    public Boolean existById(Long id) {
        return repository.existsById(id);
    }

}
