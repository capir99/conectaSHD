package co.gov.shd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.gov.shd.model.Funcionario;
import co.gov.shd.repository.IFuncionarioRepo;


@Service
public class FuncionarioServiceImp implements IFuncionarioService{

	@Autowired
	private IFuncionarioRepo repo;
	

	@Override
	public List<Funcionario> listar() {
		
		return null;
	}

}
