package com.cpadilla.market.persistence.crud;

import com.cpadilla.market.persistence.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LoginCrudRepository extends CrudRepository<CustomerEntity, Integer> {

    Optional<CustomerEntity> findByUsername(String username);
}
