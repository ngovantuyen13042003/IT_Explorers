package st.nvt.managerrestaurant.mapper;

import st.nvt.managerrestaurant.dto.FoodDTO;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.model.service.Images;

import java.util.ArrayList;
import java.util.List;

public class FoodMapper {

    public  static Food mapToFood(FoodDTO foodDTO) {
        Food food = new Food();
        food.setName(foodDTO.getName());
        food.setDescription(foodDTO.getDescription());
        food.setPrice(foodDTO.getPrice());
        food.setIngredientList(foodDTO.getIngredientList());
        Images img = new Images();
        img.setNameImage(foodDTO.getImages());
        List<Images> imgs = new ArrayList<>();
        food.setImages(imgs);
        return food;
    }
}
