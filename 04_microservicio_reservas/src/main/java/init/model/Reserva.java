package init.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="reservas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	private String usuario;
	@ManyToOne()
	@JoinColumn(name = "vuelo",referencedColumnName = "idVuelo")
	private Vuelo vuelo;
	@ManyToOne()
	@JoinColumn(name = "hotel",referencedColumnName = "idHotel")
	private Hotel hotel;
	private double precio;
}
