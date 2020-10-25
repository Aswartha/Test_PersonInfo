package com.boot.person;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.person.model.Address;
import com.boot.person.model.Person;
import com.boot.person.repository.AddressRepository;
import com.boot.person.repository.PersonRepository;

@SpringBootTest
class TestPersonApplicationTests {
	@Autowired
	PersonRepository prepo;

	@Autowired
	AddressRepository adrepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void getpersons() {
		List<Person> person = new ArrayList<>();

		person = prepo.findAll();
		
		System.out.println("PERSON :"+person.get(0).getFirstName());

	}

	@Test
	public void getpersonscount() {

		long count = prepo.count();

		System.out.println("PersonCount :" + count);
	}

	@Test
	public void getaddresses() {
		List<Address> adlist = new ArrayList<>();

		adlist = adrepo.findAll();

		adlist.forEach(adress -> System.out.println("ADDRESS :"+adress));
	}
	
	
	
	

}
