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
}
