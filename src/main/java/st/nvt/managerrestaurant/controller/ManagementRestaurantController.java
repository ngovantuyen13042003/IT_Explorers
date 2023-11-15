package st.nvt.managerrestaurant.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagementRestaurantController {
    @GetMapping("/management-restaurant")
    public String showFormAddRestaurant() {

        return "ManagementRestaurant";
    }
}