package com.shop.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @SequenceGenerator(name = "ProductIdSequence", sequenceName = "product_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductIdSequence")
    private Integer id;

    @Column
    private String url;

    @Column
    private String name;

    @Column
    private Integer price;

    @Column(name = "description")
    private String descriptionInfo;

    @OneToMany(mappedBy = "productId")
    private List<BasketEntity> basketIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescriptionInfo() {
        return descriptionInfo;
    }

    public void setDescriptionInfo(String descriptionInfo) {
        this.descriptionInfo = descriptionInfo;
    }

    public List<BasketEntity> getBasketIds() {
        return basketIds;
    }

    public void setBasketIds(List<BasketEntity> basketIds) {
        this.basketIds = basketIds;
    }
}
