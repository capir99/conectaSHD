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
import co.gov.shd.model.Mapa;
import co.gov.shd.model.Puestotrabajo;
import co.gov.shd.model.Sede;
import co.gov.shd.service.MapaService;
import co.gov.shd.service.PuestotrabajoService;
import co.gov.shd.service.SedeService;

@Controller
@RequestMapping("pue")
public class PuestotrabajoController {

	@Autowired
	private PuestotrabajoService puestotrabajoService;
	
	@Autowired
	private MapaService mapaService;

	@Autowired
	private SedeService sedeService;
	
	//************************************************Listar elementos registrados
	@RequestMapping("list")
	//@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getAllPages(Model model, @ModelAttribute("msg") String msg) {
		return getOnePage(model, 1);
	}
	
	//************************************************Listar elementos de una página en particular (paginación)
	@RequestMapping("list/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
		Page<Puestotrabajo> page = puestotrabajoService.findPage(currentPage);
		int totalPages = page.getTotalPages();
		long totalItems = page.getTotalElements();
		List<Puestotrabajo> puestotrabajos = page.getContent();
		List<Mapa> mapas = mapaService.listarMapas();
		List<Sede> sedes = sedeService.listarSedes();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("mapas", mapas);
		model.addAttribute("sedes", sedes);
		model.addAttribute("puestotrabajos", puestotrabajos);
		model.addAttribute("puestotrabajo",  new Puestotrabajo());
		return "fragments/conPue.html :: conPue";
	}

	//************************************************Mostrar pantalla registro elemento
	@RequestMapping("add")
	public String addpuestotrabajoMostar(Model model) {
		Puestotrabajo puestotrabajo = new Puestotrabajo();
		List<Puestotrabajo> puestotrabajos = puestotrabajoService.listarPuestotrabajos();
		List<Mapa> mapas = mapaService.listarMapas();
		List<Sede> sedes = sedeService.listarSedes();
		
		model.addAttribute("mapas", mapas);
		model.addAttribute("sedes", sedes);
		model.addAttribute("puestotrabajo", puestotrabajo);
		model.addAttribute("puestotrabajos", puestotrabajos);
		return "fragments/addPue.html :: addPue";
	}

	
	//************************************************Ejecutar registro nuevo elemento
	@PostMapping("addExec")
	public String addpuestotrabajoxec(@ModelAttribute("puestotrabajo") Puestotrabajo puestotrabajo, final RedirectAttributes redirectAttributes) throws IOException {
		redirectAttributes.addFlashAttribute("obj", "pue");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (puestotrabajo != null) {
			puestotrabajoService.guardarPuestotrabajo(puestotrabajo);			
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
	public String findpuestotrabajo(Model model, @PathVariable("id") int id) {

		Puestotrabajo puestotrabajo = new Puestotrabajo();
		if (id != 0) {
			puestotrabajo = puestotrabajoService.findPuestotrabajo(id);
		}

		model.addAttribute("puestotrabajo", puestotrabajo);
		return getOnePage(model, 1);

	}
	
	//************************************************Ejecutar modificación elemento
	@RequestMapping("modExec")
	public String modpuestotrabajoxec(@ModelAttribute("pue") Puestotrabajo puestotrabajo, Model model, final RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("obj", "pue");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (puestotrabajo != null) {
			puestotrabajoService.guardarPuestotrabajo(puestotrabajo);
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
	public String rempuestotrabajoxec(@ModelAttribute("pue") Puestotrabajo puestotrabajo, final RedirectAttributes redirectAttributes) throws IOException {
		redirectAttributes.addFlashAttribute("obj", "pue");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (puestotrabajo != null) {
			try {
				puestotrabajoService.removerPuestotrabajo(puestotrabajo.getId());
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