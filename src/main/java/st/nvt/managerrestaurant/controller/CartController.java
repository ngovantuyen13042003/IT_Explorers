package st.nvt.managerrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import st.nvt.managerrestaurant.service.FoodService;

@Controller
public class CartController {
    @Autowired
    FoodService foodService;

    @GetMapping("/cart")
    public String showCart() {
        return "Cart";
    }


//    @GetMapping("/addToCart/{id}")
//    public String addToCart(@PathVariable("id") Long id) {
//        CartDTO.cart.add(foodService.findById(id));
//        return "redirect:/home";
//    }
//
//    @GetMapping("/cart")
//    public String cart(Model model) {
//        model.addAttribute("cartCount", CartDTO.cart.size());
//        model.addAttribute("total", CartDTO.cart.stream().mapToDouble(Food::getPrice).sum());
//        model.addAttribute("cart", CartDTO.cart);
//        return "Cart";
//    }

}
