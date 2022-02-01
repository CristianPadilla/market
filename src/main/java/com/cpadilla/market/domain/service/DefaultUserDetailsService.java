package com.cpadilla.market.domain.service;

import com.cpadilla.market.domain.Customer;
import com.cpadilla.market.domain.repository.IProductRepository;
import com.cpadilla.market.persistence.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Customer> c = loginRepository.getUserByUsername(username);
        return c.map(custo -> new User(custo.getUsername(), "{noop}" + custo.getPassword(), new ArrayList<>()))
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("USER NOT FOUND");
                });

    }
}
