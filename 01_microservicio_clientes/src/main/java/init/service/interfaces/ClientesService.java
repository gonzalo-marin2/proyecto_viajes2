package init.service.interfaces;

import init.model.Cliente;

public interface ClientesService {
	Cliente autenticarUsuario(String usuario, String password);
	boolean altaUsuario(Cliente cliente);
}
