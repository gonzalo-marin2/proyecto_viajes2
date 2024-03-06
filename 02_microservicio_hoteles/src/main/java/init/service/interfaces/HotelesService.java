package init.service.interfaces;

import java.util.List;

import init.model.Hotel;

public interface HotelesService {
	Hotel buscarPorId(int id);
	List<Hotel> buscarPorLocalizacion(String localizacion);
	List<Hotel> hoteles();
}
