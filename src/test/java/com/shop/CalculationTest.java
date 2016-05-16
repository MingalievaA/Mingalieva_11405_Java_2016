package com.shop;

import com.shop.entity.BasketEntity;
import com.shop.entity.ProductEntity;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CalculationTest {

    List<BasketEntity> basketEntities = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        List<ProductEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(RandomStringUtils.random(10,true,false));
            productEntity.setId(i);
            productEntity.setPrice((i^2*21*2*3)+1000-i*12);
            list.add(productEntity);
        }
        for (int i = 4; i < 15; i++) {
            BasketEntity basketEntity = new BasketEntity();
            basketEntity.setId(i*2-1);
            basketEntity.setProductCount(i*16/2*3/2-1);
            basketEntity.setProductId(list.get(ThreadLocalRandom.current().nextInt(0, list.size())));
            basketEntities.add(basketEntity);
        }

    }

    @Test
    public void priceCalculate() {
        int sum = basketEntities.stream().mapToInt(a -> a.getProductCount() * a.getProductId().getPrice()).sum();
        System.out.println(sum);
        Assert.assertTrue(sum > 0);
    }
}
