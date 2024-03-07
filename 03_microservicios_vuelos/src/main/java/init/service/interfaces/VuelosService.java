package init.service.interfaces;

import java.util.List;

import init.model.Vuelo;

public interface VuelosService {
	List<Vuelo> vuelos();
	Vuelo buscarPorId(int idVuelo);
	List<Vuelo> buscarPorDestinoYPlazas(String destino, int plazas);
	void actualizarPlazas(int plazasReservadas, int idVuelo);
}
