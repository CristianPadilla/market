package com.cpadilla.market.persistence.mapper;

import com.cpadilla.market.domain.Product;
import com.cpadilla.market.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Repository
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "salePrice", target = "salePrice"),
            @Mapping(source = "amountStock", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "categoryEntity", target = "category"),
    })
    Product toProduct(ProductEntity productEntity);

    List<Product> toProducts(List<ProductEntity> productEntities);// uses the above mapping instructions for map lists

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    ProductEntity toProductEntity(Product product);


}
