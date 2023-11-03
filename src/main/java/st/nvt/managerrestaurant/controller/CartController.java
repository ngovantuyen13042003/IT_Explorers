package st.nvt.managerrestaurant.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import st.nvt.managerrestaurant.dto.CartDTO;
import st.nvt.managerrestaurant.service.CartService;
import st.nvt.managerrestaurant.service.FoodService;

import java.util.HashMap;

@Controller
public class CartController {
    @Autowired
    FoodService foodService;
    @Autowired
    CartService cartService;

    @RequestMapping("/add-cart/{id}")
    public String showCart(HttpSession session, @PathVariable("id") Long id) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
        if(cart == null ) {
            cart = new HashMap<Long, CartDTO>();
        }
        cart = cartService.addCart(id, cart);
        session.setAttribute("cart", cart);

        return "redirect:/cart";

//        return ResponseEntity.ok("Giỏ hàng của bạn đã được cập nhật");
    }

    @GetMapping("cart")
    public String cart() {
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
