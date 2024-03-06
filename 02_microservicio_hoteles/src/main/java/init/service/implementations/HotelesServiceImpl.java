package init.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import init.dao.HotelesDao;
import init.model.Hotel;
import init.service.interfaces.HotelesService;

public class HotelesServiceImpl implements HotelesService {

	@Autowired
	HotelesDao hotelesDao;
	
	@Override
	public Hotel buscarPorId(int id) {
		return hotelesDao.findById(id).orElse(null);
	}

	@Override
	public List<Hotel> buscarPorLocalizacion(String localizacion) {
		return hotelesDao.findByLocalizacion(localizacion);
	}

	@Override
	public List<Hotel> hoteles() {
		return hotelesDao.findAll();
	}

}
