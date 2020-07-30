package com.naren4b.gb.web;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naren4b.gb.model.Guest;
import com.naren4b.gb.util.GuestNotFoundException;

@RestController
@RequestMapping("/api")
public class AppRestController {

	private final Logger log = LoggerFactory.getLogger(RestController.class);

	private AppService service;

	public AppRestController(AppService service) {
		this.service = service;
	}

	@PostMapping("/guest-book")
	Guest newGuest(@RequestBody Guest newGuest) {
		log.info("Request to create guest book entry: {}", newGuest);
		return service.newGuest(newGuest);
	}

	@GetMapping("/guest-book/{id}")
	ResponseEntity<?> guest(@PathVariable Long id) throws GuestNotFoundException {
		return service.guest(id);
	}

	@GetMapping("/guest-book")
	Collection<Guest> guests() throws GuestNotFoundException {
		return service.guests();
	}

}
