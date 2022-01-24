package com.cpadilla.market.persistence.entity;

import javax.persistence.*;

// @Entity indicates that this class maps a table in database
@Entity
//then, indicate the table name
@Table(name = "product")
public class ProductEntity {

    // attributes cannot be of primitive types, use wrapper types
    @Id //this is a primary key, so...
    @GeneratedValue(strategy = GenerationType.IDENTITY) // java auto-increme id
    @Column(name = "product_id")
    private Integer productId;

    private String name; // doesn't have @Column annotation because attribute and colum name in database are the same

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "sale_price")
    private Double salePrice;

    @Column(name = "amount_stock")
    private Integer amountStock;

    private Boolean status;

    // map out relationship with category
    @ManyToOne // many products have one category
    @JoinColumn(name = "category_id",insertable = false,updatable = false)
    private CategoryEntity categoryEntity;



    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getAmountStock() {
        return amountStock;
    }

    public void setAmountStock(Integer amountStock) {
        this.amountStock = amountStock;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }
}
