package com.boot.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.boot.person.model.Address;
@EnableJpaRepositories
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
