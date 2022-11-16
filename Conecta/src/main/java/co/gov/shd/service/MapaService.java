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
import co.gov.shd.model.Mapa;
import co.gov.shd.repository.IMapaRepo;


@Service
public class MapaService {
	
	@Autowired
	private IMapaRepo repoMap;
	

	private List<Mapa> mapas =  new ArrayList(); 

	
	
    public Page<Mapa> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Mapa> list;
        
        mapas = repoMap.findAll();
        if(mapas != null){
	        if (mapas.size() < startItem) {
	            list = Collections.emptyList();
	        } else {
	            int toIndex = Math.min(startItem + pageSize, mapas.size());
	            list = mapas.subList(startItem, toIndex);
	        }
	
	        Page<Mapa> mapPage = new PageImpl<Mapa>(list, PageRequest.of(currentPage, pageSize), mapas.size());
	        return mapPage;
        }else {
        	return null;
        }
        
    }

    public Page<Mapa> findPage(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber - 1, 5, Sort.by(Sort.Direction.ASC, "id")); 		
        return repoMap.findAll(pageable);
    }
    
    public Mapa guardarMapa(Mapa mapa) {
    	return repoMap.save(mapa);
    }
    
    public void removerMapa(int id) {
    	repoMap.deleteById(id);
    }
	
    public Mapa findMapa(int id) {
    	return repoMap.findById(id).get();
    }
    
    public Mapa actualizarMapa(Mapa mapa) {
    	return repoMap.save(mapa);
    }
    
    public List<Mapa> listarMapas() {
    	return repoMap.findAll();
    }
}
