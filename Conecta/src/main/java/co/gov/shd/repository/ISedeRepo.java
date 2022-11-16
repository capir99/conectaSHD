package co.gov.shd.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.gov.shd.model.Sede;



@Service
public interface ISedeRepo extends JpaRepository<Sede, Integer> {   
   

}
