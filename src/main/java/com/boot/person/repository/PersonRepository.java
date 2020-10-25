package com.boot.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.boot.person.model.Person;

@EnableJpaRepositories
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
