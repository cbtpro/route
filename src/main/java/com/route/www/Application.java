package com.route.www;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.route.www.domain.Customer;
import com.route.www.repository.CustomerRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "18916163020"));
		repository.save(new Customer("Bob", "15021070861"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByUserName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByUserName("Alice"));

		System.out.println("Customers found with findByTel('18916163020'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByTel("18916163020")) {
			System.out.println(customer);
		}

	}

}