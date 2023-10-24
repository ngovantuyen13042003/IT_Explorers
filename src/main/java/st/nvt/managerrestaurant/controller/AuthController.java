package st.nvt.managerrestaurant.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import st.nvt.managerrestaurant.dto.AccountDTO;
import st.nvt.managerrestaurant.model.account.Account;
import st.nvt.managerrestaurant.service.IAccountService;
import st.nvt.managerrestaurant.service.IRoleService;

@Controller
@Transactional
public class AuthController {
    @Autowired
    IAccountService accountService;
    @Autowired
    IRoleService roleService;


    @GetMapping("/sign-in")
    public String showFormLogin() {

        return "SignIn";
    }

    @GetMapping("/sign-up")
    public String showFormSignUp(Model model) {
        model.addAttribute("account", new AccountDTO());
        return "SignUp";
    }

    @PostMapping("/sign-up/save")
    public String registration(@Valid @ModelAttribute("account") AccountDTO account, BindingResult result, Model model){

        if(accountService.existsByEmail(account.getEmail())) {
            result.reject("email", null, "There is a already an account registered with the same email!");
        }

        if(accountService.existsByUserName(account.getUserName())) {
            result.reject("userName", null, "There is a already an account registered with the same username!");
        }


        if(result.hasErrors()){
            model.addAttribute("user",account);
            return "SignUp";
        }

        Account acc = accountService.saveOrUpdate(account);
        return "redirect:/home";
    }

    @GetMapping("logout")
    public String signout(@ModelAttribute("account") AccountDTO userDto, WebRequest request, SessionStatus status) {
        //        Xóa session user ra khỏi vị trí
        status.setComplete();// đã hoàn thành
        request.removeAttribute("userdto",WebRequest.SCOPE_SESSION);//thực hiện xóa accountDTO ra khỏi tầm của session
        return "redirect:sign-in";
    }



}
