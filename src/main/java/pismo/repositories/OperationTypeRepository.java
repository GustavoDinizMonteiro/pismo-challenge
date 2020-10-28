package pismo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pismo.models.OperationType;

public interface OperationTypeRepository extends JpaRepository<OperationType, Long> {

}
