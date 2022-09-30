package co.gov.shd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.gov.shd.model.Funcionario;

public interface IFuncionarioRepo extends JpaRepository<Funcionario, Integer>{   

	
}
