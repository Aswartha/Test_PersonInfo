package com.boot.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.person.model.Address;
import com.boot.person.model.Person;
import com.boot.person.repository.AddressRepository;
import com.boot.person.repository.PersonRepository;

@RestController
public class PersonController {

	@Autowired
	PersonRepository repository;

	@Autowired
	AddressRepository addressrepo;

	@PostMapping("/add_person")
	public ResponseEntity<String> add_Person(@RequestBody Person person) {
        
		repository.save(person);
		

		return new ResponseEntity<String>("Person saved successfully", HttpStatus.OK);
	}

	@PutMapping("/edit_person")
	public ResponseEntity<String> edit_Person(@RequestBody Person person) {

		repository.save(person);

		return new ResponseEntity<String>("Person updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("/delete_person/{id}")
	public ResponseEntity<String> delete_Person(@PathVariable int id) {

		repository.deleteById(id);

		return new ResponseEntity<String>("Person deleted successfully", HttpStatus.OK);
	}

	@PostMapping("/add_address_person/{person_id}")
	public ResponseEntity<String> addAddress_Person(@PathVariable int person_id, @RequestBody Address adress) {

		Person pp = repository.findById(person_id).orElse(new Person());
		Address ade = new Address(adress.getStreet(), adress.getCity(), adress.getState(), adress.getPostalCode());
		ade.setPerson(pp);
		addressrepo.save(ade);

		return new ResponseEntity<String>("Address saved successfully", HttpStatus.OK);
	}

	@PutMapping("/add_update_person/{person_id}")
	public ResponseEntity<String> update_Address_Person(@PathVariable int person_id, @RequestBody Address adress) {

		Person pp = repository.findById(person_id).orElse(new Person());
		adress.setPerson(pp);
		addressrepo.save(adress);

		return new ResponseEntity<String>("Address updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("/deleteaddress_person/{id}")
	public ResponseEntity<String> deleteAddress_Person(@PathVariable int id) {

		addressrepo.deleteById(id);

		return new ResponseEntity<String>("Address deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/get_persons_count")
	public ResponseEntity<String> get_AllPersonCount() {

		long countperons = repository.count();

		return new ResponseEntity<String>("Total persons :" + countperons, HttpStatus.OK);
	}

	@GetMapping("/get_persons")
	public List<Person> get_AllPerson() {

		return repository.findAll();
	}

	@GetMapping("/get_address")
	public List<Address> get_AllAddress() {

		return addressrepo.findAll();
	}

}
