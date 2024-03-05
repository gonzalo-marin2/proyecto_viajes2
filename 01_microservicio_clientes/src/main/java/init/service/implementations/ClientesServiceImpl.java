package init.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dao.ClientesDao;
import init.model.Cliente;
import init.service.interfaces.ClientesService;

@Service
public class ClientesServiceImpl implements ClientesService {
	@Autowired
	ClientesDao clientesDao;
	
	@Override
	public Cliente autenticarUsuario(String usuario, String password) {
		Cliente cliente=clientesDao.findByUsuarioAndPassword(usuario, password);
		return cliente!=null?cliente:null;
	}

	@Override
	public Cliente altaUsuario(Cliente cliente) {
		if(clientesDao.findByUsuario(cliente.getUsuario())==null) {
			clientesDao.save(cliente);
			return cliente;
		}
		return null;
	}

}
