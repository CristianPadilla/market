package com.cpadilla.market.persistence.mapper;

import com.cpadilla.market.domain.PurchaseItem;
import com.cpadilla.market.persistence.entity.PurchaseProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
// though we ignore productEntity mapping, we need to use ProductMapper
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.productId", target = "productId"),
            @Mapping(source = "amount", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "status", target = "active")
    })
    PurchaseItem toPurchaseItem(PurchaseProductEntity purchaseProductEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchaseEntity", ignore = true),
            @Mapping(target = "productEntity", ignore = true),
            @Mapping(target = "id.purchaseId", ignore = true)
    })
    PurchaseProductEntity toPurchaseProduct(PurchaseItem item);
}
