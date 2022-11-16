package co.gov.shd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.gov.shd.model.Funcionario;
import co.gov.shd.repository.IDependenciaRepo;
import co.gov.shd.repository.IFuncionarioRepo;

@Controller
public class MenuController {

	@Autowired
	private IDependenciaRepo repoDep;
	@Autowired
	private IFuncionarioRepo repoFunc;
	
	
	@GetMapping("/conecta")
	public String greeting(Model model) {	
		model.addAttribute("jerarquia1", repoDep.getAllJerarquia(1) );
		model.addAttribute("jerarquia2", repoDep.getAllJerarquia(2) );
		model.addAttribute("jerarquia3", repoDep.getAllJerarquia(3) );
		model.addAttribute("funcionarios", repoFunc.findAll() );
		return "conecta";
	}

}
