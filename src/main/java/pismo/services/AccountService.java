package pismo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pismo.exceptions.EntityNotFoundException;
import pismo.models.Account;
import pismo.repositories.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository repository;
	
	public void create(Account account) {
		repository.save(account);
	}
	
	public Account getById(Long id) {
		var account = repository.findById(id);
		if (account.isEmpty())
			throw new EntityNotFoundException();
		
		return account.get();
	}
}