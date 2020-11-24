package pismo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pismo.models.Account;
import pismo.services.AccountService;

@RestController
@CrossOrigin
@RequestMapping("accounts")
public class AccountController {
	@Autowired
	private AccountService service;
	
	@PostMapping
	public ResponseEntity<Account> create(@RequestBody Account account) {
		return ResponseEntity.ok(service.create(account));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> get(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}
}
