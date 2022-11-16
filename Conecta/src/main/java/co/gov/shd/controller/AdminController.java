package co.gov.shd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.gov.shd.model.Funcionario;
import co.gov.shd.repository.IDependenciaRepo;
import co.gov.shd.repository.IFuncionarioRepo;

@Controller
public class AdminController {

	@Autowired
	private IDependenciaRepo repoDep;
	@Autowired
	private IFuncionarioRepo repoFunc;
	
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String greeting(Model model) {	
		return "adminLayout";
	}

	
}
