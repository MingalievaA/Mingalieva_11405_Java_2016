package com.shop.controller;

import com.shop.entity.BasketEntity;
import com.shop.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addProduct(@PathVariable("productId") Integer productId){
        basketService.save(productId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getBasket(ModelMap map){
        List<BasketEntity> ba = basketService.getBaskerForCurrentUser();
        Integer sum = ba.stream().mapToInt(a -> a.getProductId().getPrice() * a.getProductCount()).sum();
        map.addAttribute("baskets", ba);
        map.addAttribute("sum", sum);
        return "basket";
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.POST)
    @ResponseBody
    public Integer removeProductFromBasket(@PathVariable("productId") Integer id){
        basketService.removeProductFromBasket(id);
        List<BasketEntity> ba = basketService.getBaskerForCurrentUser();
        return ba.stream().mapToInt(a -> a.getProductId().getPrice() * a.getProductCount()).sum();
    }


    @RequestMapping(value = "/end-buy", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void endBuy(){
        basketService.endBuy();
    }

    @RequestMapping(value = "/paid", method = RequestMethod.GET)
    public String paidOrders(ModelMap map){
        List<BasketEntity> ba = basketService.getPaidOrderBasketForCurrectUser();
        map.addAttribute("baskets", ba);
        map.addAttribute("sum", ba.stream().mapToInt(a -> a.getProductId().getPrice() * a.getProductCount()).sum());
        return "paid";
    }
}
