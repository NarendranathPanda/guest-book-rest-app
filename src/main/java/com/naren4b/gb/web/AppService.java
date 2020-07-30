package com.naren4b.gb.web;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.naren4b.gb.model.Guest;
import com.naren4b.gb.model.GuestRepository;
import com.naren4b.gb.util.GuestNotFoundException;

@Service
public class AppService {

	private GuestRepository repository;

	private final Logger log = LoggerFactory.getLogger(AppService.class);

	public AppService(GuestRepository repository) {
		this.repository = repository;
	}

	Guest newGuest(Guest newGuest) {
		log.info("Request to create group: {}", newGuest);
		return repository.save(newGuest);
	}

	ResponseEntity<?> guest(Long id) throws GuestNotFoundException {
		Optional<Guest> entry = repository.findById(id);
		return entry.map(response -> ResponseEntity.ok().body(response))
				.orElseThrow(() -> new GuestNotFoundException(id));
	}

	Collection<Guest> guests() {
		return repository.findAll();
	}

}
