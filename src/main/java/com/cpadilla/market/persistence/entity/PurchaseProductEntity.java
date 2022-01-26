package com.cpadilla.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "purchase_product")
public class PurchaseProductEntity {

    // composed PK
    @EmbeddedId
    private PurchaseProductPKEntity id;

    private Integer amount;
    private Double total;
    private Boolean status;

    @ManyToOne
    @MapsId("purchaseId") // PK attribute in PurchaseEntity for when saving in cascade, every item knows what purchase corresponds through that attribute
    @JoinColumn(name = "purchase_id", insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity productEntity;


    public PurchaseProductPKEntity getId() {
        return id;
    }

    public void setId(PurchaseProductPKEntity id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public PurchaseEntity getPurchaseEntity() {
        return purchaseEntity;
    }

    public void setPurchaseEntity(PurchaseEntity purchaseEntity) {
        this.purchaseEntity = purchaseEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
