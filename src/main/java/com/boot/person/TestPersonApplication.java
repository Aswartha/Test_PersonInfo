package com.boot.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.boot.person.model.Address;
import com.boot.person.model.Person;
import com.boot.person.repository.AddressRepository;
import com.boot.person.repository.PersonRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class TestPersonApplication implements CommandLineRunner {

	@Autowired
	PersonRepository prepo;
	@Autowired
	AddressRepository adrepo;

	public static void main(String[] args) {
		SpringApplication.run(TestPersonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Person p = new Person("Aswartha", "palla");

		Address ad = new Address("street", "city", "state", 516492);
		Address ad1 = new Address("street1", "city1", "state1", 525898);
		ad.setPerson(p);
		ad1.setPerson(p);
		List<Address> listad = new ArrayList<>();
		listad.add(ad);
		listad.add(ad1);
		p.setAddresslist(listad);
		prepo.save(p);

		// List<Person> dd = prepo.findAll();

		// System.out.println("" + dd.get(0).getFirstName());

	}

}
