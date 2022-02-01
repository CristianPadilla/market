package com.cpadilla.market.persistence.mapper;

import com.cpadilla.market.domain.Customer;
import com.cpadilla.market.persistence.entity.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password")
    })
    Customer toCustomer(CustomerEntity customerEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name", ignore = true),
            @Mapping(target = "surname", ignore = true),
            @Mapping(target = "phoneNumber", ignore = true),
            @Mapping(target = "address", ignore = true),
            @Mapping(target = "email", ignore = true),
            @Mapping(target = "purchaseEntities", ignore = true)
    })
    CustomerEntity toCustomerEntity (Customer customer);
}
