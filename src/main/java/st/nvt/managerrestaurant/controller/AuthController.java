package st.nvt.managerrestaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class AuthController {

    @GetMapping("/sign-in")
    public String showFormLogin() {
        return "SignIn";
    }

    @GetMapping("/sign-up")
    public String showFormSignUp() {
        return "SignUp";
    }


}
