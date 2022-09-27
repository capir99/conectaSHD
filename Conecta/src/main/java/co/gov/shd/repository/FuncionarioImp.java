package co.gov.shd.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import co.gov.shd.ConectaApplication;

@Repository
public class FuncionarioImp implements IFuncionario {

	private static Logger LOG = LoggerFactory.getLogger(ConectaApplication.class);
	
	@Override
	public void registrar(String nombres, String apellidos, String ident) {
		LOG.info("Funcionario " + nombres + "  " + apellidos +  " registrado exitosamente ");
		
	}

	
	
}
