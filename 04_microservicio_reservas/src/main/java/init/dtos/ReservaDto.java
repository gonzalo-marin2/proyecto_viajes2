package init.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservaDto {
	private int idReserva;
	private String usuario;
	@JsonProperty(value = "vuelo")
	private VueloDto vueloDto;
	@JsonProperty(value = "hotel")
	private HotelDto hotelDto;
	private double precio;
	public ReservaDto() {
		vueloDto=new VueloDto();
		hotelDto=new HotelDto();
	}
}
