package com.shop.controller;

import com.shop.form.RegistrationForm;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getUserRegistrationPage(Model model) {
        model.addAttribute("userform", new RegistrationForm());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userform") @Valid RegistrationForm form, BindingResult result, Model model) {

        userService.validLogin(result, form);
        userService.validPassword(result, form);

        if (result.hasErrors()) {
            return "registration";
        }

        userService.saveNewUser(form);
        return "redirect:/";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(@RequestParam(value = "error", required = false) String error, ModelMap model) {
        if (error != null) {
            model.addAttribute("error", "Authentication failed!");
        }
        return "login";
    }

}
