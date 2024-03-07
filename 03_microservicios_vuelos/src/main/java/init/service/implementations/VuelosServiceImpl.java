package init.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dao.VuelosDao;
import init.model.Vuelo;
import init.service.interfaces.VuelosService;

@Service
public class VuelosServiceImpl implements VuelosService {
	
	@Autowired
	VuelosDao vuelosDao;

	@Override
	public List<Vuelo> vuelos() {
		return vuelosDao.findAll();
	}

	@Override
	public Vuelo buscarPorId(int idVuelo) {
		return vuelosDao.findById(idVuelo).orElse(null);
	}

	@Override
	public List<Vuelo> buscarPorDestinoYPlazas(String destino, int plazas) {
		List<Vuelo> vuelos=vuelosDao.findByDestinoYPlazas(destino, plazas);
		if(vuelos!=null) {
			return vuelos;
		}
		return null;
	}

	@Override
	public void actualizarPlazas(int plazasReservadas, int idVuelo) {	
		vuelosDao.updatePlazas(plazasReservadas, idVuelo);
	}

}
