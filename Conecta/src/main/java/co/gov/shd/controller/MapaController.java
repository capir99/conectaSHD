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
import co.gov.shd.service.MapaService;

@Controller
@RequestMapping("map")
public class MapaController {

	@Autowired
	private MapaService mapService;

	
	//************************************************Listar elementos registrados
	@RequestMapping("list")
	//@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getAllPages(Model model, @ModelAttribute("msg") String msg) {
		return getOnePage(model, 1);
	}
	
	//************************************************Listar elementos de una página en particular (paginación)
	@RequestMapping("list/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
		Page<Mapa> page = mapService.findPage(currentPage);
		int totalPages = page.getTotalPages();
		long totalItems = page.getTotalElements();
		List<Mapa> mapas = page.getContent();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("mapas", mapas);
		model.addAttribute("map",  new Mapa());
		return "fragments/conMap.html :: conMap";
	}

	//************************************************Mostrar pantalla registro elemento
	@RequestMapping("add")
	public String addmapMostar(Model model) {
		Mapa mapa = new Mapa();
		List<Mapa> mapas = mapService.listarMapas();
		
		model.addAttribute("mapa", mapa);
		model.addAttribute("mapas", mapas);
		return "fragments/addMap.html :: addMap";
	}

	
	//************************************************Ejecutar registro nuevo elemento
	@PostMapping("addExec")
	public String addMapaxec(@ModelAttribute("mapa") Mapa map, final RedirectAttributes redirectAttributes) throws IOException {
		redirectAttributes.addFlashAttribute("obj", "map");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (map != null) {
			mapService.guardarMapa(map);			
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
	public String findmap(Model model, @PathVariable("id") int id) {

		Mapa Mapa = new Mapa();
		if (id != 0) {
			Mapa = mapService.findMapa(id);
		}

		model.addAttribute("Mapa", Mapa);
		return getOnePage(model, 1);

	}
	
	//************************************************Ejecutar modificación elemento
	@RequestMapping("modExec")
	public String modMapaxec(@ModelAttribute("map") Mapa map, Model model, final RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("obj", "map");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (map != null) {
			mapService.guardarMapa(map);
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
	public String remMapaxec(@ModelAttribute("mapa") Mapa map, final RedirectAttributes redirectAttributes) throws IOException {
		redirectAttributes.addFlashAttribute("obj", "map");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (map != null) {
			try {
				mapService.removerMapa(map.getId());
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