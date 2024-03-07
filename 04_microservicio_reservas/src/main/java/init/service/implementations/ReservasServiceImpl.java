package init.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import init.dao.ReservasDao;
import init.model.Reserva;
import init.service.interfaces.ReservasService;
import init.service.mappers.Mapeador;

public class ReservasServiceImpl implements ReservasService {
	
	@Autowired
	ReservasDao reservasDao;
	
	@Autowired
	Mapeador mapeador;

	@Override
	public void alta() {
		
	}

	@Override
	public List<Reserva> reservasPorUsuario(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
