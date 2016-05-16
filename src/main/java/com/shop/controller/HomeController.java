package com.shop.controller;

import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {


    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap map){
        map.addAttribute("goods", productRepository.findAll());
        return "index";
    }
}
