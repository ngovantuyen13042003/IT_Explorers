package st.nvt.managerrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.service.FoodService;

@Controller
public class HomeController {
    @Autowired
    private FoodService foodService;

//    @GetMapping
//    public  String  showHome(){
//        return "Home";
//    }

    @GetMapping
    public String menu(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 9;
        Page<Food> foodPage = foodService.listFoods(page,pageSize);
        model.addAttribute("menu", foodPage.getContent());
        model.addAttribute("page", foodPage);
        return "Home";
    }
}
