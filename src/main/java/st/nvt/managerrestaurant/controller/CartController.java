package st.nvt.managerrestaurant.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.apache.catalina.authenticator.SpnegoAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import st.nvt.managerrestaurant.model.account.Account;
import st.nvt.managerrestaurant.model.account.Customer;
import st.nvt.managerrestaurant.model.service.Cart;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.service.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Controller
@Transactional
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    CustomerService customerService;
    @Autowired
    IAccountService accountService;

    @GetMapping("/add-cart/{id}")
        public String showCart( @PathVariable("id") Long id, Principal principal) throws Exception {
//        if(principal == null) {
//            return "redirect:/login";
//        }
        Account account = accountService.findByUserName(principal.getName());
        Customer customer = customerService.findById(account.getCustomerId()).orElseThrow(
                () -> new Exception()
        );

        cartService.addCart(id, customer.getId());
        return "forward:/home";
    }


    @GetMapping("/cart")
    public String cart(Model model, Principal principal, HttpServletResponse response, HttpSession session) throws Exception {
        if(principal==null){
            return "redirect:/login";
        }
        Account account = accountService.findByUserName(principal.getName());
        Customer customer = customerService.findById(account.getCustomerId()).orElseThrow(
                () -> new Exception()
        );
        List<Cart> carts = cartService.getAll(customer.getId());

        double totalBill = 0.0;
        int totalQuantity = 0;
        for (Cart cart : carts) {
            totalBill += cart.getTotalPrice();
            totalQuantity += cart.getTotalItems();
        }

        model.addAttribute("totalBill", totalBill);
        model.addAttribute("totalQuantity", totalQuantity);
        session.setAttribute("totalQuantity", totalQuantity);


        model.addAttribute("carts", carts);
        return "Cart";
    }

    @GetMapping("/remove-cart/{id}")
    public String removeCart(@PathVariable("id") Long id) {
        cartService.remove(id);
        return "redirect:/cart";
    }



}
