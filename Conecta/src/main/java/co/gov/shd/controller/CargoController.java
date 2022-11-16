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
import co.gov.shd.model.Cargo;
import co.gov.shd.service.CargoService;

@Controller
@RequestMapping("car")
public class CargoController {

	@Autowired
	private CargoService carService;

	
	//************************************************Listar elementos registrados
	@RequestMapping("list")
	//@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getAllPages(Model model, @ModelAttribute("msg") String msg) {
		return getOnePage(model, 1);
	}
	
	//************************************************Listar elementos de una página en particular (paginación)
	@RequestMapping("list/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
		Page<Cargo> page = carService.findPage(currentPage);
		int totalPages = page.getTotalPages();
		long totalItems = page.getTotalElements();
		List<Cargo> cargos = page.getContent();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("cargos", cargos);
		model.addAttribute("car",  new Cargo());
		return "fragments/conCar.html :: conCar";
	}

	//************************************************Mostrar pantalla registro elemento
	@RequestMapping("add")
	public String addcarMostar(Model model) {
		Cargo cargo = new Cargo();
		List<Cargo> cargos = carService.listarCargos();
		
		model.addAttribute("cargo", cargo);
		model.addAttribute("cargos", cargos);
		return "fragments/addCar.html :: addCar";
	}

	
	//************************************************Ejecutar registro nuevo elemento
	@PostMapping("addExec")
	public String addcarExec(@ModelAttribute("cargo") Cargo car, final RedirectAttributes redirectAttributes) throws IOException {
		redirectAttributes.addFlashAttribute("obj", "car");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (car != null) {
			carService.guardarCargo(car);			
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
	public String findcar(Model model, @PathVariable("id") int id) {

		Cargo cargo = new Cargo();
		if (id != 0) {
			cargo = carService.findCargo(id);
		}

		model.addAttribute("cargo", cargo);
		return getOnePage(model, 1);

	}
	
	//************************************************Ejecutar modificación elemento
	@RequestMapping("modExec")
	public String modcarExec(@ModelAttribute("car") Cargo car, Model model, final RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("obj", "car");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (car != null) {
			carService.guardarCargo(car);
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
	public String remcarExec(@ModelAttribute("car") Cargo car, final RedirectAttributes redirectAttributes) throws IOException {
		redirectAttributes.addFlashAttribute("obj", "car");
		redirectAttributes.addFlashAttribute("sen", "list");
		if (car != null) {
			try {
				carService.removerCargo(car.getId());
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