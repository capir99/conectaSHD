package co.gov.shd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.gov.shd.model.Funcionario;
import co.gov.shd.repository.IFuncionarioRepo;

@Controller
public class FuncionarioController {

	 @Autowired
	 private IFuncionarioRepo repo;
	@GetMapping("/crearf")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
		//Logica
		
		Funcionario f = new Funcionario();
		f.setId(2);
	    f.setNombres("Juan Sebastian");
	    f.setApellidos("Castro");
		repo.save(f);
		
		
		model.addAttribute("name", name);
		return "conecta";
	}
	

	@GetMapping("/listar")
	public String greeting(Model model) {	
		
		model.addAttribute("funcionarios", repo.findAll() );
		return "listar";
	}

}
