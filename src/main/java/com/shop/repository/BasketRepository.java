package com.shop.repository;

import com.shop.entity.BasketEntity;
import com.shop.entity.ProductEntity;
import com.shop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<BasketEntity, Integer> {

    @Query(value = "select b from BasketEntity b where b.userId = :user and b.basketId is null")
    List<BasketEntity> findAllByUserAndBasketId(@Param("user") UserEntity user);

    @Query(value = "select b from BasketEntity b where b.userId = :user and b.productId = :product and b.basketId is null")
    BasketEntity findByUserAndProduct(@Param("user") UserEntity user, @Param("product") ProductEntity productEntity);

    @Modifying
    @Transactional
    @Query("delete from BasketEntity b where b.userId = :user and b.productId = :product and b.basketId is null")
    void deleteByProduct(@Param("user") UserEntity user, @Param("product") ProductEntity productId);

    @Query("select b from BasketEntity b where b.userId = :user and b.basketId is not null")
    List<BasketEntity> findAllPaidOrder(@Param("user") UserEntity user);
}
