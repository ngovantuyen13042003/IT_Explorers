package st.nvt.managerrestaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantController {
    @GetMapping("/add-restaurant")
    public String showFormAddRestaurant() {

        return "AddRestaurant";
    }

    @GetMapping("/update-infor-restaurant")
    public String updateInforRes() {
        return "UpdateInforRestaurant";
    }

    @GetMapping("/restaurant/food-list")
    public String showfoodList(){
        return "RestaurantFoodList";
    }
}
