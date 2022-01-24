package com.cpadilla.market.persistence.mapper;

import com.cpadilla.market.domain.Category;
import com.cpadilla.market.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            // mapping from com.cpadilla.market.persistence.entity.Category to com.cpadilla.market.domain.Category
            @Mapping(source = "categoryId", target = "categoryId"), // source = CategoryEntity , target = Category
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active"),
    })
    Category toCategory(CategoryEntity categoryEntity);

    @InheritInverseConfiguration // mapstruc detects the inverse case of the above conversion
    @Mapping(target = "productEntities", ignore = true) // ignore productEntities attribute, we don't need to map it
    CategoryEntity toCategoryEntity(Category category);

}
