package pismo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pismo.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
