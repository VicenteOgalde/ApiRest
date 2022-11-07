package cl.doumopractico.formulario.DTO;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

public class PersonaDTO {
	private Long id;
	@NotBlank(message = "Nombre no puede estar en blanco")
	private String nombre;
	@NotBlank(message = "Apellido no puede estar en blanco")
	private String apellido;
	@Email(message = "Ingresar email valido")
	private String correo;
	@NotBlank(message = "Fecha de nacimiento no puede estar en blanco y debe estar en el formato dd/MM/yyyy")
	private String fechaNacimiento;
	@Size(min=8, message = "Minimo de 8 caracteres")
	private String telefono;
	@Size(min=5, message = "Minimo de 5 caracteres")
	private String region;
	@Size(min=5, message = "Minimo de 5 caracteres")
	private String comuna;
	
	public PersonaDTO(String nombre,String apellido,String correo, String fechaNacimiento,String telefono,
			String region,String comuna) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.region = region;
		this.comuna = comuna;
	}
	


}
