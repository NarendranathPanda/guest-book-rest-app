package com.naren4b.gb;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.naren4b.gb.model.Guest;
import com.naren4b.gb.model.GuestRepository;

@Component
public class Initializer implements CommandLineRunner {

	private final GuestRepository repository;

	public Initializer(GuestRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) {
		Guest gb = new Guest();
		gb.setCreated(new Date());
		gb.setEmail("abc@abc.com");
		gb.setName("Naren");
		gb.setNote("Hi");
		gb.setPhoneno("9991212");
		repository.save(gb);
		repository.findAll().forEach(System.out::println);
	}

}