package st.nvt.managerrestaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import st.nvt.managerrestaurant.model.service.Food;

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
    public String showfoodList(@ModelAttribute Food food, Model model){
        model.addAttribute("food", food);
        return "RestaurantFoodList";
    }
}
