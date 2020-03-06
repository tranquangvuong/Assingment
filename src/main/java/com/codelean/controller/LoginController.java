package com.codelean.controller;

import com.codelean.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {

    @GetMapping("/")
    public String login() {
        return "trangchu/login";
    }

    @PostMapping("/login")
    public ModelAndView login(Model model, @RequestParam("fullname") String fullname, @RequestParam("password") String password) {
        Account account = new Account(fullname, password);
        model.addAttribute("message", "Dang nhap thanh cong");
        ModelAndView modelAndView = new ModelAndView("trangchu/home", "account", account);
        return modelAndView;
    }
//
//    @GetMapping("/")
//    public String disLogin(Model model){
//        Account account = new Account();
//        model.addAttribute("account",account);
//        return "login";
//
//    }
//
//        @PostMapping("/login")
//    public  String progessLogin(@Valid @ModelAttribute("account") Account account, Errors errors, Model model){
//        if (errors.hasErrors()){
//            return "login";
//        }
//            return "home";
//        }

}
