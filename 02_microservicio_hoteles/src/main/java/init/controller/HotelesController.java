package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import init.dao.HotelesDao;
import init.model.Hotel;
import init.service.interfaces.HotelesService;

@CrossOrigin("*")
@RestController
public class HotelesController {
	
	@Autowired
	HotelesService service;
	@Autowired
	HotelesDao hotelesDao;
	
	@GetMapping(value="id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hotel> buscarPorId(@PathVariable("id") int id){
			return new ResponseEntity<>(service.buscarPorId(id),HttpStatus.OK);
	}
	
	@GetMapping(value="localizacion/{localizacion}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Hotel>> buscarPorLocalizacion(@PathVariable("localizacion") String localizacion){
		return new ResponseEntity<>(service.buscarPorLocalizacion(localizacion),HttpStatus.OK);
	}
}
