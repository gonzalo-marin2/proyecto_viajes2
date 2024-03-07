package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import init.model.Vuelo;
import init.service.interfaces.VuelosService;

@CrossOrigin
@RestController
public class VuelosController {

	@Autowired
	VuelosService service;
	
	@GetMapping(value="id/{idVuelo}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vuelo> buscarPorId(@PathVariable("idVuelo") int idVuelo){
		Vuelo vuelo=service.buscarPorId(idVuelo);
		if(vuelo!=null) {
			return new ResponseEntity<>(vuelo,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@GetMapping(value="destino/{destino}/{plazas}",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Vuelo> BuscarPorDestinoYPlazas(@PathVariable("destino") String destino, @PathVariable("plazas") int plazas){
		return service.buscarPorDestinoYPlazas(destino, plazas);
		
	}
	
	@PutMapping(value="actualizar/{plazasReservadas}/{idVuelo}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> actualizar(@PathVariable("plazasReservadas") int plazasReservadas, @PathVariable("idVuelo") int idVuelo){
		service.actualizarPlazas(plazasReservadas, idVuelo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
