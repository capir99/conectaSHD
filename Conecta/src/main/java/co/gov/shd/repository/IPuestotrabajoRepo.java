package co.gov.shd.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.gov.shd.model.Puestotrabajo;



@Service
public interface IPuestotrabajoRepo extends JpaRepository<Puestotrabajo, Integer> {   
   

}
