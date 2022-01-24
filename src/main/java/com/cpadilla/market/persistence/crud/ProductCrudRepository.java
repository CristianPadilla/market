package com.cpadilla.market.persistence.crud;

import com.cpadilla.market.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> { // Integer represents id datatype

    /*
     all the methods in this interface are spring data jpa query methods.
     query methods documentation: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
     be careful writing this method's names, must use camel case, the "CategoryId" part of the name means to com.cpadilla.market.persistence.entity.ProductEntity
     parameter names must be exactly equal to com.cpadilla.market.persistence.entity.Product.categoryId too
    */
    List<ProductEntity> findByCategoryIdOrderByName(int categoryId);

    Optional<List<ProductEntity>> findByAmountStockLessThanAndStatus(int amountStock, boolean status);


}
