package com.cpadilla.market.persistence.mapper;

import com.cpadilla.market.domain.Purchase;
import com.cpadilla.market.persistence.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "purchaseId", target = "purchaseId"),
            @Mapping(source = "customerId", target = "clientId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "commentary", target = "comment"),
            @Mapping(source = "status", target = "state"),
            @Mapping(source = "products", target = "items")
    })
    Purchase toPurchase(PurchaseEntity purchaseEntity);

    List<Purchase> toPurchases(List<PurchaseEntity> purchaseEntities);

    @InheritInverseConfiguration
    @Mapping(target = "customerEntity", ignore = true)
    PurchaseEntity toPurchaseEntity(Purchase purchase);
}
