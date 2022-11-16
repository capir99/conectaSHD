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
import co.gov.shd.model.Puestotrabajo;
import co.gov.shd.repository.IPuestotrabajoRepo;


@Service
public class PuestotrabajoService {
	
	@Autowired
	private IPuestotrabajoRepo repoPuestotrabajo;
	

	private List<Puestotrabajo> puestotrabajos =  new ArrayList(); 

	
	
    public Page<Puestotrabajo> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Puestotrabajo> list;
        
        puestotrabajos = repoPuestotrabajo.findAll();
        if(puestotrabajos != null){
	        if (puestotrabajos.size() < startItem) {
	            list = Collections.emptyList();
	        } else {
	            int toIndex = Math.min(startItem + pageSize, puestotrabajos.size());
	            list = puestotrabajos.subList(startItem, toIndex);
	        }
	
	        Page<Puestotrabajo> puestotrabajoPage = new PageImpl<Puestotrabajo>(list, PageRequest.of(currentPage, pageSize), puestotrabajos.size());
	        return puestotrabajoPage;
        }else {
        	return null;
        }
        
    }

    public Page<Puestotrabajo> findPage(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber - 1, 5, Sort.by(Sort.Direction.ASC, "id")); 		
        return repoPuestotrabajo.findAll(pageable);
    }
    
    public Puestotrabajo guardarPuestotrabajo(Puestotrabajo puestotrabajo) {
    	return repoPuestotrabajo.save(puestotrabajo);
    }
    
    public void removerPuestotrabajo(int id) {
    	repoPuestotrabajo.deleteById(id);
    }
	
    public Puestotrabajo findPuestotrabajo(int id) {
    	return repoPuestotrabajo.findById(id).get();
    }
    
    public Puestotrabajo actualizarPuestotrabajo(Puestotrabajo puestotrabajo) {
    	return repoPuestotrabajo.save(puestotrabajo);
    }
    
    public List<Puestotrabajo> listarPuestotrabajos() {
    	return repoPuestotrabajo.findAll();
    }
}
