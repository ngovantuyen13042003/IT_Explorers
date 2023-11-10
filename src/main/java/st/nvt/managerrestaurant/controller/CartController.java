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
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.model.service.Images;
import st.nvt.managerrestaurant.service.CartService;
import st.nvt.managerrestaurant.service.FoodService;
import st.nvt.managerrestaurant.service.ImagesService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {
    @Autowired
    FoodService foodService;
    @Autowired
    CartService cartService;
    @Autowired
    ImagesService imagesService;

    @RequestMapping("/add-cart/{id}")
    public String showCart(HttpSession session, @PathVariable("id") Long id) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
        if(cart == null ) {
            cart = new HashMap<Long, CartDTO>();
        }

        cart = cartService.addCart(id, cart);

        session.setAttribute("tatalPrice", cartService.totalPrice(cart));
        session.setAttribute("tatalQuantity", cartService.totalQuantity(cart));
        session.setAttribute("cart", cart);
        return "redirect:/home";
    }

    @RequestMapping("/remove-cart/{id}")
    public String removeCart(HttpSession session, @PathVariable("id") Long id) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");


        cart = cartService.removeCart(id, cart);

        session.setAttribute("tatalPrice", cartService.totalPrice(cart));
        session.setAttribute("tatalQuantity", cartService.totalQuantity(cart));
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }




    @GetMapping("cart")
    public String cart() {
        return "Cart";
    }



}
