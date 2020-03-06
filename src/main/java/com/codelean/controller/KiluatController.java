package com.codelean.controller;

import com.codelean.model.Kiluat;
import com.codelean.model.Nhanvien;
import com.codelean.model.Phongban;
import com.codelean.service.KiluatService;
import com.codelean.service.NhanvienService;
import com.codelean.service.PhongbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class KiluatController {
    @Autowired
    private KiluatService kiluatService;

    @Autowired
    private NhanvienService nhanvienService;


    @ModelAttribute("nhanviens")
    public Iterable<Nhanvien> Nhanviens(){
        return nhanvienService.findAll();
    }


    @GetMapping("/kiluats")
    public ModelAndView listkl(){
        Iterable<Kiluat> kiluats = kiluatService.findAll();
        ModelAndView modelAndView = new ModelAndView("/kiluat/list");
        modelAndView.addObject("kiluats", kiluats);
        return modelAndView;
    }

    @GetMapping("/create-kiluat")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/kiluat/create");
        modelAndView.addObject("kiluat", new Kiluat());
        return modelAndView;
    }

//    @PostMapping("/create-kiluat")
//    public ModelAndView save(@ModelAttribute("kiluat")Kiluat kiluat){
//        kiluatService.save(kiluat);
//        ModelAndView modelAndView = new ModelAndView("/kiluat/create");
//        modelAndView.addObject("kiluat", new Kiluat());
//        modelAndView.addObject("message", "New customer created successfully");
//        return modelAndView;
//    }

    @PostMapping("/create-kiluat")
    public ModelAndView validate(@Valid @ModelAttribute("kiluat") Kiluat kiluat, BindingResult bindingResult, ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()){
            modelAndView.addObject("message","please correct error");
            modelMap.addAttribute("bindingResult",bindingResult);
        }
        else {
            kiluatService.save(kiluat);
            modelAndView.addObject("message","kiluat is successfull");
        }
        modelAndView = new ModelAndView("/kiluat/create");
        modelAndView.addObject("message", new Kiluat());
        modelAndView.addObject("message", "New created successfully");
        return modelAndView;
    }

    @GetMapping("/delete-kiluat/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Kiluat> kiluat = kiluatService.findById(id);
        if(kiluat != null) {
            ModelAndView modelAndView = new ModelAndView("/kiluat/delete");
            modelAndView.addObject("kiluat", kiluat);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-kiluat")
    public String delete(@ModelAttribute("kiluat") Kiluat kiluat){
        kiluatService.remove(kiluat.getId());
        return "redirect:kiluats";
    }


    @GetMapping("/kiluat-validate")
    public String showForm(Model model){
        model.addAttribute("kiluat", new Kiluat());
        return "create";
    }

    @PostMapping("/kiluat-validate")
    public String checkValidation (@Validated @ModelAttribute("kiluat") Kiluat kiluat, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "create";
        }
        return "result";
    }
}
