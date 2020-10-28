package pismo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pismo.models.Transaction;
import pismo.services.TransactionService;

@RestController
@CrossOrigin
@RequestMapping("transactions")
public class TransactionController {
	@Autowired
	private TransactionService service;
	
	@PostMapping
	public BodyBuilder create(@RequestBody Transaction transaction) {
		service.create(transaction);
		return ResponseEntity.ok();
	}
}
