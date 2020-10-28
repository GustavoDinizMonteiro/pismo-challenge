package pismo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pismo.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
