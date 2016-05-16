package com.shop.entity;

import javax.persistence.*;

@Entity
@Table(name = "basket")
public class BasketEntity {

    @Id
    @SequenceGenerator(name = "BasketIdSequence", sequenceName = "basket_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BasketIdSequence")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity productId;

    @Column(name = "basket_id")
    private String basketId;

    @Column(name = "product_count")
    private Integer productCount;

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public ProductEntity getProductId() {
        return productId;
    }

    public void setProductId(ProductEntity productId) {
        this.productId = productId;
    }

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }
}
