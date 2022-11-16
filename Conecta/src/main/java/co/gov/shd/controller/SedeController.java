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
import co.gov.shd.model.Sede;
import co.gov.shd.service.SedeService;


@Controller
@RequestMapping("sed")
public class SedeController {

	@Autowired
	private SedeService sedService;

	
	//************************************************Listar elementos registrados
	@RequestMapping("list")
	//@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getAllPages(Model model, @ModelAttribute("msg") String msg) {
		return getOnePage(model, 1);
	}
	
	//************************************************Listar elementos de una página en particular (paginación)
	@RequestMapping("list/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
		Page<Sede> page = sedService.findPage(currentPage);
		int totalPages = page.getTotalPages();
		long totalItems = page.getTotalElements();
		List<Sede> sedes = page.getContent();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("sedes", sedes);
		model.addAttribute("sed",  new Sede());
		return "fragments/conSed.html :: conSed";
	}

	//************************************************Mostrar pantalla registro elemento
	@RequestMapping("add")
	public String addsedMostar(Model model) {
		Sede sede = new Sede();
		List<Sede> sedes = sedService.listarSedes();
		
		model.addAttribute("sede", sede);
		model.addAttribute("sedes", sedes);
		return "fragments/addSed.html :: addSed";
	}

	
	//************************************************Ejecutar registro nuevo elemento
	@PostMapping("addExec")
	public String addsedExec(@ModelAttribute("sede") Sede sed, final RedirectAttributes redirectAttributes) throws IOException {
		redirectAttributes.addFlashAttribute("obj", "sed");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (sed != null) {
			sedService.guardarSede(sed);			
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
	public String findsed(Model model, @PathVariable("id") int id) {

		Sede sede = new Sede();
		if (id != 0) {
			sede = sedService.findSede(id);
		}

		model.addAttribute("sede", sede);
		return getOnePage(model, 1);

	}
	
	//************************************************Ejecutar modificación elemento
	@RequestMapping("modExec")
	public String modsedExec(@ModelAttribute("sed") Sede sed, Model model, final RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("obj", "sed");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (sed != null) {
			sedService.guardarSede(sed);
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
	public String remsedExec(@ModelAttribute("sed") Sede sed, final RedirectAttributes redirectAttributes) throws IOException {
		redirectAttributes.addFlashAttribute("obj", "sed");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (sed != null) {
			try {
				sedService.removerSede(sed.getId());
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