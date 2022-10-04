package co.gov.shd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.gov.shd.model.Funcionario;

@Service
public interface IFuncionarioRepo extends JpaRepository<Funcionario, Integer>{   

	
}
