package init.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dao.HotelesDao;
import init.model.Hotel;
import init.service.interfaces.HotelesService;

@Service
public class HotelesServiceImpl implements HotelesService {

	@Autowired
	HotelesDao hotelesDao;
	
	@Override
	public Hotel buscarPorId(int idHotel) {
		return hotelesDao.findById(idHotel).orElse(null);
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
