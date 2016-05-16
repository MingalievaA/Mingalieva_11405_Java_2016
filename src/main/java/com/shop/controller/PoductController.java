package com.shop.controller;

import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PoductController {

    @Autowired
    private ProductRepository repository;

    @RequestMapping(value = "/info/{productId}", method = RequestMethod.GET)
    public String productInfo(ModelMap map, @PathVariable("productId") Integer id){
        map.addAttribute("product", repository.findOne(id));
        return "info";
    }
}
