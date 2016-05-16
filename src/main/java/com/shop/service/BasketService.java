package com.shop.service;

import com.shop.entity.BasketEntity;
import com.shop.entity.ProductEntity;
import com.shop.entity.UserEntity;
import com.shop.repository.BasketRepository;
import com.shop.repository.ProductRepository;
import com.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BasketService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BasketRepository basketRepository;

    public void save(Integer productId){
        ProductEntity productEntity = productRepository.findOne(productId);
        BasketEntity basketEntity = basketRepository.findByUserAndProduct(getUser(), productEntity);
        if(basketEntity != null){
            basketEntity.setProductCount(basketEntity.getProductCount() + 1);
        }else {
            UserEntity user = getUser();
            basketEntity = new BasketEntity();
            basketEntity.setUserId(user);
            basketEntity.setProductId(productEntity);
            basketEntity.setProductCount(1);
        }
        basketRepository.save(basketEntity);
    }

    public List<BasketEntity> getBaskerForCurrentUser(){
        return basketRepository.findAllByUserAndBasketId(getUser());
    }

    public List<BasketEntity> getPaidOrderBasketForCurrectUser(){
        return basketRepository.findAllPaidOrder(getUser());
    }

    private UserEntity getUser() {
        return userRepository.findOneByLogin(((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getLogin());
    }

    public void removeProductFromBasket(Integer id) {
        basketRepository.deleteByProduct(getUser(), productRepository.findOne(id));
    }

    public void endBuy() {
        List<BasketEntity> allByUserAndBasketId = basketRepository.findAllByUserAndBasketId(getUser());
        String basketId = UUID.randomUUID().toString();
        allByUserAndBasketId.forEach(e -> e.setBasketId(basketId));
        basketRepository.save(allByUserAndBasketId);
    }
}
