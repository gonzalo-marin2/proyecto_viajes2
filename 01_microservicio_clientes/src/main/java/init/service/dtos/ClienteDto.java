package init.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDto {
	private String usuario;
	private String password;
	private String direccion;
	private String tarjeta;
	private String dni;
}
