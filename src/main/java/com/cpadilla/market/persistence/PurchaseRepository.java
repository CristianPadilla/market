package com.cpadilla.market.persistence;

import com.cpadilla.market.domain.Purchase;
import com.cpadilla.market.domain.repository.IPurchaseRepository;
import com.cpadilla.market.persistence.crud.PurchaseCrudRepository;
import com.cpadilla.market.persistence.entity.PurchaseEntity;
import com.cpadilla.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements IPurchaseRepository {

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<PurchaseEntity>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseCrudRepository.findByCustomerId(clientId)
                .map(purchaseEntities -> mapper.toPurchases(purchaseEntities));
    }

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEntity purchaseEntity = mapper.toPurchaseEntity(purchase);
        // make sure this information will be saved in cascade (purchase and purchase_product insertions in database), that is, make sure
        //items attribute in PurchaseEntity has "cascade = {CascadeType.ALL}"
        purchaseEntity.getProducts().forEach(productEntity -> productEntity.setPurchaseEntity(purchaseEntity));
        return mapper.toPurchase(purchaseCrudRepository.save(purchaseEntity));
    }
}
