package com.cpadilla.market.persistence;

import com.cpadilla.market.domain.Customer;
import com.cpadilla.market.persistence.crud.LoginCrudRepository;
import com.cpadilla.market.persistence.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LoginRepository {

    @Autowired
    private LoginCrudRepository loginCrudRepository;

    @Autowired
    private CustomerMapper mapper;

    public Optional<Customer> getUserByUsername(String username){
        return loginCrudRepository.findByUsername(username).map(user -> mapper.toCustomer(user));
    }
}
