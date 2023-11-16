package st.nvt.managerrestaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import st.nvt.managerrestaurant.model.service.TypeRestaurant;
import st.nvt.managerrestaurant.repository.ITypeRestaurantRepository;
import st.nvt.managerrestaurant.service.TypeRestaurantService;

import java.util.List;
@Service
public class TypeRestaurantServiceImpl implements TypeRestaurantService {
    @Autowired
    private ITypeRestaurantRepository repository;
    @Override
    public List<TypeRestaurant> findAll() {
        return repository.findAll();
    }
}
