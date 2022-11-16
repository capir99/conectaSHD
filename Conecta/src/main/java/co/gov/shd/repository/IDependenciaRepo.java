package co.gov.shd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import co.gov.shd.model.Dependencia;


@Service
public interface IDependenciaRepo extends JpaRepository<Dependencia, Integer> {   
   
	//JPQL
	@Query("select d from Dependencia d where d.jerarquia=?1")
	public List<Dependencia> getAllJerarquia(Integer jer);
	
}
