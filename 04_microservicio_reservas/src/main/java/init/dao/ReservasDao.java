package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.model.Reserva;

public interface ReservasDao extends JpaRepository<Reserva, Integer> {
	//heredado: save()
	
	List<Reserva> findByUsuario(String usuario);
}
