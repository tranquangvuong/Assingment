package com.codelean.controller;

import com.codelean.model.Account;
import com.codelean.model.Phongban;
import com.codelean.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AccountController {

@Autowired
private AccountService accountService;


    @GetMapping("/create-account")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/account/create");
        modelAndView.addObject("account", new Account());
        return modelAndView;
    }

    @PostMapping("/create-account")
    public ModelAndView validate(@Valid @ModelAttribute("account") Account account, BindingResult bindingResult, ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()){
            modelAndView.addObject("message","please correct error");
            modelMap.addAttribute("bindingResult",bindingResult);
        }
        else {
            accountService.save(account);
            modelAndView.addObject("message","account is successfull");
        }
        modelAndView = new ModelAndView("/account/create");
        modelAndView.addObject("message", new Account());
        modelAndView.addObject("message", "New created successfully");
        return modelAndView;
    }
}
