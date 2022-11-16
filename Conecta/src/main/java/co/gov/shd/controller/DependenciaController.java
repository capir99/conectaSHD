package co.gov.shd.controller;


import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import co.gov.shd.model.Dependencia;
import co.gov.shd.service.DependenciaService;

@Controller
@RequestMapping("dep")
public class DependenciaController {

	@Autowired
	private DependenciaService depService;

	
	//************************************************Listar elementos registrados
	@RequestMapping("list")
	//@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getAllPages(Model model, @ModelAttribute("msg") String msg) {
		return getOnePage(model, 1);
	}
	
	//************************************************Listar elementos de una página en particular (paginación)
	@RequestMapping("list/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
		Page<Dependencia> page = depService.findPage(currentPage);
		int totalPages = page.getTotalPages();
		long totalItems = page.getTotalElements();
		List<Dependencia> dependencias = page.getContent();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("dependencias", dependencias);
		model.addAttribute("dep",  new Dependencia());
		return "fragments/conDep.html :: conDep";
	}

	//************************************************Mostrar pantalla registro elemento
	@RequestMapping("add")
	public String addDepMostar(Model model) {
		Dependencia dependencia = new Dependencia();
		List<Dependencia> dependencias = depService.listarDependencias();
		
		model.addAttribute("dependencia", dependencia);
		model.addAttribute("dependencias", dependencias);
		return "fragments/addDep.html :: addDep";
	}

	
	//************************************************Ejecutar registro nuevo elemento
	@PostMapping("addExec")
	public String addDepExec(@ModelAttribute("dependencia") Dependencia dep, final RedirectAttributes redirectAttributes) throws IOException {
		redirectAttributes.addFlashAttribute("obj", "dep");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (dep != null) {
			depService.guardarDependencia(dep);			
			redirectAttributes.addFlashAttribute("msg", "Registro exitoso");
			redirectAttributes.addFlashAttribute("typ", "s");
		}else {
			redirectAttributes.addFlashAttribute("msg", "No hay objeto");
			redirectAttributes.addFlashAttribute("typ", "w");
		}
		return "redirect:../admin"; 

	}

	//************************************************Consultar elemento específico
	@RequestMapping("find/{id}")
	public String findDep(Model model, @PathVariable("id") int id) {

		Dependencia dependencia = new Dependencia();
		if (id != 0) {
			dependencia = depService.findDependencia(id);
		}

		model.addAttribute("dependencia", dependencia);
		return getOnePage(model, 1);

	}
	
	//************************************************Ejecutar modificación elemento
	@RequestMapping("modExec")
	public String modDepExec(@ModelAttribute("dep") Dependencia dep, Model model, final RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("obj", "dep");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (dep != null) {
			depService.guardarDependencia(dep);
			redirectAttributes.addFlashAttribute("msg", "Edición exitosa");
			redirectAttributes.addFlashAttribute("typ", "s");
		}else{
			redirectAttributes.addFlashAttribute("msg", "No hay objeto");
			redirectAttributes.addFlashAttribute("typ", "w");
		}
		return "redirect:../admin"; 
	}
	
	//************************************************Eliminar elemento específico
	@PostMapping("remExec")
	public String remDepExec(@ModelAttribute("dep") Dependencia dep, final RedirectAttributes redirectAttributes) throws IOException {
		redirectAttributes.addFlashAttribute("obj", "dep");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (dep != null) {
			try {
				depService.removerDependencia(dep.getId());
				redirectAttributes.addFlashAttribute("msg", "Eliminación exitosa");
				redirectAttributes.addFlashAttribute("typ", "s");
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("msg", "Hay un objeto anidado que debe eliminarse primero (integridad referencial)");
				redirectAttributes.addFlashAttribute("typ", "e");
			}
			
			
		}else {
			redirectAttributes.addFlashAttribute("msg", "No hay objeto");
			redirectAttributes.addFlashAttribute("typ", "w");
		}
		return "redirect:../admin"; 

	}

	

}