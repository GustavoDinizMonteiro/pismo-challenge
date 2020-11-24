package pismo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import pismo.exceptions.TransactionBlockedException;
import pismo.models.Transaction;
import pismo.repositories.AccountRepository;
import pismo.repositories.TransactionRepository;

@Service
public class TransactionService {
	private static final Long PAYMENT_OPERATION_ID = (long) 4;
	
	@Autowired
	private TransactionRepository trasactionRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public Transaction create(Transaction transaction) {
		var account = accountRepository.getOne(transaction.getAccount().getId());
		var credit = account.getCreditLimit();
		var transactionAmount = transaction.getAmount();
		
		if (transaction.getOperationType().getId() != PAYMENT_OPERATION_ID && credit < Math.abs(transactionAmount)) {
			throw new TransactionBlockedException("Credit not available.");
		}
		
		account.setCreditLimit(credit + transactionAmount);
		trasactionRepository.save(transaction);
		accountRepository.save(account);
		
		return transaction;
	}
}
