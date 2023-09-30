package st.nvt.managerrestaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.model.service.Images;
import st.nvt.managerrestaurant.repository.ImagesRepository;
import st.nvt.managerrestaurant.service.ImagesService;

import java.util.List;


@Service
public class ImagesServiceImpl implements ImagesService {
    @Autowired
    private ImagesRepository imagesRepository;

    @Override
    public Images saveOrUpdate(Images image) {
        return imagesRepository.save(image);
    }

    @Override
    public List<Images> findByFood(Food food) {
        return imagesRepository.findByFood(food);
    }

    @Override
    public Images findTop1ByFood(Long id) {
        return imagesRepository.findTop1ByFood(id);
    }

    @Override
    public List<Images> findAll() {
        return imagesRepository.findAll();
    }
}
