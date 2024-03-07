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
	
	public Vuelo vueloDtoToVueloEntity(VueloDto vueloDto) {
		return new Vuelo(vueloDto.getIdVuelo(),
				vueloDto.getCompany(),
				vueloDto.getFecha(),
				vueloDto.getPrecio(),
				vueloDto.getPlazas(),
				vueloDto.getDestino());
	}
	
	public VueloDto vueloEntityToDto(Vuelo vuelo) {
		return new VueloDto(vuelo.getIdVuelo(),
				vuelo.getCompany(),
				vuelo.getFecha(),
				vuelo.getPrecio(),
				vuelo.getPlazas(),
				vuelo.getDestino());
	}
	
	public Hotel hotelDtoToHotelEntity(HotelDto hotelDto) {
		return new Hotel(hotelDto.getIdHotel(),
				hotelDto.getNombre(),
				hotelDto.getCategoria(),
				hotelDto.getPrecio(),
				hotelDto.isDisponible(),
				hotelDto.getLocalizacion());
	}
	
	public HotelDto hotelEntityToDto(Hotel hotel) {
		return new HotelDto(hotel.getIdHotel(),
				hotel.getNombre(),
				hotel.getCategoria(),
				hotel.getPrecio(),
				hotel.isDisponible(),
				hotel.getLocalizacion());
	}
	
	/*public Reserva reservaDtoToReservaEntity(ReservaDto reservaDto) {
		return new Reserva(reservaDto.get)
	}*/
	
	public ReservaDto reservaEntityToReservaDto(Reserva reserva) {
		return new ReservaDto(reserva.getIdReserva(),
				reserva.getUsuario(),
				reserva.VueloDto,
				reserva.getHotel(),
				reserva.getPrecio());
	}
}
