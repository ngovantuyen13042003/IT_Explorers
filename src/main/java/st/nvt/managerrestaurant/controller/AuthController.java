package st.nvt.managerrestaurant.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import st.nvt.managerrestaurant.dto.AccountDTO;
import st.nvt.managerrestaurant.dto.CustomerDTO;
import st.nvt.managerrestaurant.dto.RestaurantOwnerDTO;
import st.nvt.managerrestaurant.model.account.Account;
import st.nvt.managerrestaurant.repository.CustomerRepository;
import st.nvt.managerrestaurant.service.IAccountService;
import st.nvt.managerrestaurant.service.IRoleService;

import java.util.Map;

@Controller
@Transactional
public class AuthController {
    @Autowired
    IAccountService accountService;
    @Autowired
    IRoleService roleService;
    @Autowired
    CustomerRepository customerRepository;


    @GetMapping ("/login")
    public String showFormLogin() {
        return "SignIn";
    }

//    @GetMapping("/signin-google")
//    public Map<String, Object> currentUser(OAuth2AuthenticationToken auth2AuthenticationToken) {
//        return auth2AuthenticationToken.getPrincipal().getAttributes();
//    }


    @GetMapping("/sign-up")
    public String showFormSignUp(Model model) {
        model.addAttribute("customer", new CustomerDTO());
        return "SignUp";
    }

    @PostMapping("/sign-up/save")
    public String registration(@Valid @ModelAttribute("customer") CustomerDTO customerDTO, BindingResult result, Model model){

        if(customerRepository.existsByEmail(customerDTO.getEmail())) {
            result.reject("email", null, "There is a already an account registered with the same email!");
        }

        if(accountService.existsByUserName(customerDTO.getUsername())) {
            result.reject("username", null, "There is a already an account registered with the same username!");
        }

        if(result.hasErrors()){
            model.addAttribute("user",customerDTO);
            return "SignUp";
        }

        accountService.saveOrUpdate(customerDTO);

//        Account acc = accountService.saveOrUpdate(customerDTO);
        return "redirect:/home";
    }


    @GetMapping("logout")
    public String signout(@ModelAttribute("account") AccountDTO userDto, WebRequest request, SessionStatus status) {
        //        Xóa session user ra khỏi vị trí
        status.setComplete();// đã hoàn thành
        request.removeAttribute("userdto",WebRequest.SCOPE_SESSION);//thực hiện xóa accountDTO ra khỏi tầm của session
        return "redirect:/login";
    }

    @GetMapping("/register-owner")
    public String showFormRegister(Model model) {
        model.addAttribute("restaurantowner", new RestaurantOwnerDTO());
        return "RestaurantOwnerRegister";
    }

}
