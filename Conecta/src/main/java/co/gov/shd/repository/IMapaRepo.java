package co.gov.shd.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.gov.shd.model.Mapa;



@Service
public interface IMapaRepo extends JpaRepository<Mapa, Integer> {   
   

}
