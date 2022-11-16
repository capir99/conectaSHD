package co.gov.shd.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.gov.shd.model.Cargo;



@Service
public interface ICargoRepo extends JpaRepository<Cargo, Integer> {   
   

}
