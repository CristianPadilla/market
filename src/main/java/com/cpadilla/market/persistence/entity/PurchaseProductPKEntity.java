package com.cpadilla.market.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

// represents the PurchaseProduct composed primary key
@Embeddable
public class PurchaseProductPKEntity implements Serializable {

    @Column(name = "purchase_id")
    private Integer purchaseId;

    @Column(name = "product_id")
    private Integer productId;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
