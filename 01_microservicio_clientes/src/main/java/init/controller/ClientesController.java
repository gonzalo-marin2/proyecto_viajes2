package init.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import init.dao.ClientesDao;
import init.model.Cliente;
import init.service.interfaces.ClientesService;

@CrossOrigin("*")
@RestController
public class ClientesController {
	@Autowired
	ClientesService service;
	@Autowired
	ClientesDao clientesDao;
	
	@GetMapping(value="acceso/{usuario}/{password}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> autenticarUsuario(@PathVariable("usuario") String usuario,@PathVariable("password") String password){
		Cliente cliente=service.autenticarUsuario(usuario, password);
			if(cliente==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(cliente,HttpStatus.OK);
		}
	
	@PostMapping(value="registro",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> altaUsuario(@RequestBody Cliente cliente){
		if(service.altaUsuario(cliente)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
}
