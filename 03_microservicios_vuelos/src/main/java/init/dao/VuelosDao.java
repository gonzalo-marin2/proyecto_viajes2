package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import init.model.Vuelo;

public interface VuelosDao extends JpaRepository<Vuelo, Integer> {
	//heredado: findById(idVuelo);
	//heredado: findAll();
	
	@Query("select v from Vuelo v where v.destino=?1 and v.plazas>=?2")
	List<Vuelo> findByDestinoYPlazas(String destino, int plazas);
	
	@Transactional
	@Modifying
	@Query("update Vuelo v set v.plazas=v.plazas-?1 where v.idVuelo=?2 and v.plazas-?1>=0")
	void updatePlazas(int plazasReservadas, int idVuelo);
}
