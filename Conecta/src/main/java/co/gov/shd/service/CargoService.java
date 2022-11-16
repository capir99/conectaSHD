package co.gov.shd.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import co.gov.shd.model.Cargo;
import co.gov.shd.repository.ICargoRepo;


@Service
public class CargoService {
	
	@Autowired
	private ICargoRepo repoCar;
	

	private List<Cargo> cargos =  new ArrayList(); 

	
	
    public Page<Cargo> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Cargo> list;
        
        cargos = repoCar.findAll();
        if(cargos != null){
	        if (cargos.size() < startItem) {
	            list = Collections.emptyList();
	        } else {
	            int toIndex = Math.min(startItem + pageSize, cargos.size());
	            list = cargos.subList(startItem, toIndex);
	        }
	
	        Page<Cargo> carPage = new PageImpl<Cargo>(list, PageRequest.of(currentPage, pageSize), cargos.size());
	        return carPage;
        }else {
        	return null;
        }
        
    }

    public Page<Cargo> findPage(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber - 1, 5, Sort.by(Sort.Direction.ASC, "id")); 		
        return repoCar.findAll(pageable);
    }
    
    public Cargo guardarCargo(Cargo Cargo) {
    	return repoCar.save(Cargo);
    }
    
    public void removerCargo(int id) {
    	repoCar.deleteById(id);
    }
	
    public Cargo findCargo(int id) {
    	return repoCar.findById(id).get();
    }
    
    public Cargo actualizarCargo(Cargo Cargo) {
    	return repoCar.save(Cargo);
    }
    
    public List<Cargo> listarCargos() {
    	return repoCar.findAll();
    }
}
