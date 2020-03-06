package com.codelean.controller;

import com.codelean.model.Kiluat;
import com.codelean.model.Nhanvien;
import com.codelean.model.Phongban;
import com.codelean.repository.NhanvienRepository;
import com.codelean.service.KiluatService;
import com.codelean.service.NhanvienService;
import com.codelean.service.PhongbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.PublicKey;
import java.util.Optional;

@Controller
public class NhanvienController {


    @Autowired
    private NhanvienService nhanvienService;

    @Autowired
    private PhongbanService phongbanService;

    @Autowired
    private KiluatService kiluatService;

    @ModelAttribute("phongbans")
    public Iterable<Phongban> Phongbans(){
        return phongbanService.findAll();
    }

    @GetMapping("/nhanviens")
    public ModelAndView list(){
        Iterable<Nhanvien> nhanviens = nhanvienService.findAll();
        ModelAndView modelAndView = new ModelAndView("/nhanvien/list");
        modelAndView.addObject("nhanviens", nhanviens);
        return modelAndView;
    }


    @GetMapping("/create-nhanvien")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/nhanvien/create");
        modelAndView.addObject("nhanvien", new Nhanvien());
        return modelAndView;
    }
//
//    @PostMapping("/create-nhanvien")
//    public ModelAndView save(@ModelAttribute("nhanvien") Nhanvien nhanvien){
//
//        nhanvienService.save(nhanvien);
//        ModelAndView modelAndView = new ModelAndView("/nhanvien/create");
//        modelAndView.addObject("nhanvien", new Nhanvien());
//        modelAndView.addObject("message", "New created successfully");
//        return modelAndView;
//    }

//    @GetMapping("/create-nhanvien")
//    public String showSignUpForm(Nhanvien nhanvien) {
//        return "create";
//    }
//
//    @PostMapping("/create-nhanvien")
//    public String addUser(@Valid Nhanvien nhanvien, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "create";
//        }
//
//        nhanvienService.save(nhanvien);
//        model.addAttribute("nhanviens", nhanvienService.findAll());
//        return "create";
//    }
//
//    // additional CRUD methods
//}




//    @PostMapping("/create-nhanvien")
//    public ModelAndView save(@ModelAttribute("nhanvien") Nhanvien nhanvien){
//
//        nhanvienService.save(nhanvien);
//        ModelAndView modelAndView = new ModelAndView("/nhanvien/create");
//        modelAndView.addObject("nhanvien", new Nhanvien());
//        modelAndView.addObject("message", "New created successfully");
//        return modelAndView;
//    }

    @PostMapping("/create-nhanvien")
    public ModelAndView validate(@Valid @ModelAttribute("nhanvien") Nhanvien nhanvien, BindingResult bindingResult, ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()){
            modelAndView.addObject("message","please correct error");
            modelMap.addAttribute("bindingResult",bindingResult);
        }
        else {
            nhanvienService.save(nhanvien);
            modelAndView.addObject("message","nhan vien is successfull");
        }
        modelAndView = new ModelAndView("/nhanvien/create");
        modelAndView.addObject("message", new Nhanvien());
        modelAndView.addObject("message", "New created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-nhanvien/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Nhanvien> nhanvien = nhanvienService.findById(id);
        if(nhanvien != null) {
            ModelAndView modelAndView = new ModelAndView("/nhanvien/edit");
            modelAndView.addObject("nhanvien", nhanvien);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-nhanvien")
    public ModelAndView update(@ModelAttribute("nhanvien") Nhanvien nhanvien){
        nhanvienService.save(nhanvien);
        ModelAndView modelAndView = new ModelAndView("/nhanvien/edit");
        modelAndView.addObject("nhanvien", nhanvien);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-nhanvien/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Nhanvien> nhanvien = nhanvienService.findById(id);
        if(nhanvien != null) {
            ModelAndView modelAndView = new ModelAndView("/nhanvien/delete");
            modelAndView.addObject("nhanvien", nhanvien);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }



    @PostMapping("/delete-nhanvien")
    public String delete(@ModelAttribute("nhanvien") Nhanvien nhanvien){
        nhanvienService.remove(nhanvien.getId());
        return "redirect:nhanviens";
    }

    @GetMapping("/view-nhanvien/{id}")
    public ModelAndView view(@PathVariable("id") Long id){
        Optional<Nhanvien> nhanvien = nhanvienService.findById(id);
        if(nhanvien == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Kiluat> kiluats = kiluatService.findAllByNhanvien(nhanvien.get());
        ModelAndView modelAndView = new ModelAndView("/nhanvien/view");
        modelAndView.addObject("nhanvien", nhanvien);
        modelAndView.addObject("kiluats", kiluats);
        return modelAndView;
    }

    @GetMapping("/nhanvien-validate")
    public String showForm(Model model){
        model.addAttribute("nhanvien", new Nhanvien());
        return "nhanvien/create.html";
    }

    @PostMapping("/nhanvien-validate")
    public String checkValidation (@Validated @ModelAttribute("nhanvien") Nhanvien nhanvien, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "nhanvien/create.html";
        }
        return "nhanvien/result.html";
    }

}
