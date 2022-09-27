package co.gov.shd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.gov.shd.repository.IFuncionario;

@Service
public class FuncionarioServiceImp implements IFuncionarioService{

	@Autowired
	private IFuncionario repo;
	
	@Override
	public void registrar(String nombres, String Apellidos, String ident) {
		repo.registrar(nombres, Apellidos, ident);
		
	}

}
