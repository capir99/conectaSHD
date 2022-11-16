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
import co.gov.shd.model.Sede;
import co.gov.shd.repository.ISedeRepo;


@Service
public class SedeService {
	
	@Autowired
	private ISedeRepo repoSed;
	

	private List<Sede> sedes =  new ArrayList(); 

	
	
    public Page<Sede> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Sede> list;
        
        sedes = repoSed.findAll();
        if(sedes != null){
	        if (sedes.size() < startItem) {
	            list = Collections.emptyList();
	        } else {
	            int toIndex = Math.min(startItem + pageSize, sedes.size());
	            list = sedes.subList(startItem, toIndex);
	        }
	
	        Page<Sede> sedPage = new PageImpl<Sede>(list, PageRequest.of(currentPage, pageSize), sedes.size());
	        return sedPage;
        }else {
        	return null;
        }
        
    }

    public Page<Sede> findPage(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber - 1, 5, Sort.by(Sort.Direction.ASC, "id")); 		
        return repoSed.findAll(pageable);
    }
    
    public Sede guardarSede(Sede sede) {
    	return repoSed.save(sede);
    }
    
    public void removerSede(int id) {
    	repoSed.deleteById(id);
    }
	
    public Sede findSede(int id) {
    	return repoSed.findById(id).get();
    }
    
    public Sede actualizarSede(Sede sede) {
    	return repoSed.save(sede);
    }
    
    public List<Sede> listarSedes() {
    	return repoSed.findAll();
    }
}
