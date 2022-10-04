package co.gov.shd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.gov.shd.model.Funcionario;
import co.gov.shd.repository.IFuncionarioRepo;

@Controller
public class MenuController {

	@Autowired
	private IFuncionarioRepo repo;
	@GetMapping("/conecta")
	public String greeting(Model model) {	
		
		model.addAttribute("funcionarios", repo.findAll() );
		return "conecta";
	}

}
