package init.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import init.model.Cliente;
import init.service.interfaces.ClientesService;

@RestController
public class ClientesController {
	@Autowired
	ClientesService service;
	
	@GetMapping(value="acceso",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> autenticarUsuario(@RequestParam("usuario") String usuario,@RequestParam("password") String password){
		Cliente cliente=service.autenticarUsuario(usuario, password);
			if(cliente==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(cliente,HttpStatus.OK);
		}
	
	@PostMapping(value="registro",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> altaUsuario(@RequestBody Cliente cliente){
		if(cliente.getUsuario()==null&&cliente.getPassword()==null) {
			return new ResponseEntity<>(service.altaUsuario(cliente),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
