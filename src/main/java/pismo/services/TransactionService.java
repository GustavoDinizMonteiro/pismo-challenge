package pismo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pismo.models.Transaction;
import pismo.repositories.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository repository;
	
	public void create(Transaction transaction) {
		repository.save(transaction);
	}
}
