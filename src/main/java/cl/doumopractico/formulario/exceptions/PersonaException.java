package cl.doumopractico.formulario.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
@Data
public class PersonaException extends RuntimeException {

	private String mensaje;
	private HttpStatus httpStatus;
	
	public PersonaException(String mensaje, HttpStatus httpStatus) {
		super(mensaje);
		this.mensaje=mensaje;
		this.httpStatus=httpStatus;
	}
}
