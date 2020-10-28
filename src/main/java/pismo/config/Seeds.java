package pismo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import pismo.models.OperationType;
import pismo.repositories.OperationTypeRepository;

@Component
public class Seeds implements ApplicationRunner{
	
	@Autowired
	private OperationTypeRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		repository.saveAll(
			Arrays.asList(
				new OperationType("COMPRA A VISTA"),
				new OperationType("COMPRA PARCELADA"),
				new OperationType("SAQUE"),
				new OperationType("PAGAMENTO")
			)
		);
	}
}
