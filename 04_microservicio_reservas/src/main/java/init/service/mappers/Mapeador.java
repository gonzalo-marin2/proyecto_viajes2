package init.service.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import init.dtos.HotelDto;
import init.dtos.ReservaDto;
import init.dtos.VueloDto;
import init.model.Hotel;
import init.model.Reserva;
import init.model.Vuelo;
import init.service.interfaces.ReservasService;

public class Mapeador {

	@Autowired
	ReservasService service;
	
	public Vuelo dtoToVuelo(VueloDto vueloDto) {
		return new Vuelo(vueloDto.getIdVuelo(),
				vueloDto.getCompany(),
				vueloDto.getFecha(),
				vueloDto.getPrecio(),
				vueloDto.getPlazas(),
				vueloDto.getDestino());
	}
	
	public VueloDto vueloToDto(Vuelo vuelo) {
		return new VueloDto(vuelo.getIdVuelo(),
				vuelo.getCompany(),
				vuelo.getFecha(),
				vuelo.getPrecio(),
				vuelo.getPlazas(),
				vuelo.getDestino());
	}
	
	public Hotel dtoToHotel(HotelDto hotelDto) {
		return new Hotel(hotelDto.getIdHotel(),
				hotelDto.getNombre(),
				hotelDto.getCategoria(),
				hotelDto.getPrecio(),
				hotelDto.isDisponible(),
				hotelDto.getLocalizacion());
	}
	
	public HotelDto hotelToDto(Hotel hotel) {
		return new HotelDto(hotel.getIdHotel(),
				hotel.getNombre(),
				hotel.getCategoria(),
				hotel.getPrecio(),
				hotel.isDisponible(),
				hotel.getLocalizacion());
	}
	
	/*public Reserva dtoToReserva(ReservaDto reserva) {
		return new Reserva(reserva.getIdReserva(),
				reserva.getUsuario(),
				dtoToVuelo(reserva.getVueloDto()),
				dtoToHotel(reserva.getHotelDto()),
				reserva.getPrecio());
	}*/


	
	/*public ReservaDto reservaToDto(Reserva reserva) {
		return new ReservaDto(reserva.getIdReserva(),
				reserva.getUsuario(),
				vueloToDto(reserva.getVuelo()),
				hotelToDto(reserva.getHotel()),
				reserva.getPrecio());
	}*/
}
