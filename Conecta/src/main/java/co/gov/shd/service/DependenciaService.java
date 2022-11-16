package co.gov.shd.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.gov.shd.model.Dependencia;
import co.gov.shd.repository.IDependenciaRepo;


@Service
public class DependenciaService {
	
	@Autowired
	private IDependenciaRepo repoDep;
	

	private List<Dependencia> deps =  new ArrayList(); 

	
	
    public Page<Dependencia> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Dependencia> list;
        
        deps = repoDep.findAll();
        if(deps != null){
	        if (deps.size() < startItem) {
	            list = Collections.emptyList();
	        } else {
	            int toIndex = Math.min(startItem + pageSize, deps.size());
	            list = deps.subList(startItem, toIndex);
	        }
	
	        Page<Dependencia> depPage = new PageImpl<Dependencia>(list, PageRequest.of(currentPage, pageSize), deps.size());
	        return depPage;
        }else {
        	return null;
        }
        
    }

    public Page<Dependencia> findPage(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber - 1, 5, Sort.by(Sort.Direction.ASC, "id")); 		
        return repoDep.findAll(pageable);
    }
    
    public Dependencia guardarDependencia(Dependencia dependencia) {
    	return repoDep.save(dependencia);
    }
    
    public void removerDependencia(int id) {
    	repoDep.deleteById(id);
    }
	
    public Dependencia findDependencia(int id) {
    	return repoDep.findById(id).get();
    }
    
    public Dependencia actualizarDependencia(Dependencia dependencia) {
    	return repoDep.save(dependencia);
    }
    
    public List<Dependencia> listarDependencias() {
    	return repoDep.findAll();
    }
}
