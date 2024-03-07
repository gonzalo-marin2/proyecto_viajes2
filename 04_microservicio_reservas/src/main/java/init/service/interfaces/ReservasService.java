package init.service.interfaces;

import java.util.List;

import init.model.Reserva;

public interface ReservasService {
	void alta();
	List<Reserva> reservasPorUsuario(String usuario);
}
