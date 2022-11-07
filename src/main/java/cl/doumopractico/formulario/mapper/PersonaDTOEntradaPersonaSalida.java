package cl.doumopractico.formulario.mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import cl.doumopractico.formulario.DTO.PersonaDTO;
import cl.doumopractico.formulario.modelo.Persona;
@Component
public class PersonaDTOEntradaPersonaSalida implements IMapper<PersonaDTO, Persona>{

	@Override
	public Persona map(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		persona.setNombre(personaDTO.getNombre());
		persona.setApellido(personaDTO.getApellido());
		persona.setCorreo(personaDTO.getCorreo());
		DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		try {
			persona.setFechaNacimiento(fecha.parse(personaDTO.getFechaNacimiento()));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		persona.setTelefono(personaDTO.getTelefono());
		persona.setRegion(personaDTO.getRegion());
		persona.setComuna(personaDTO.getComuna());
		return persona;
	}
	public Persona mapEditar(Persona persona,PersonaDTO personaDTO) {
		
		persona.setNombre(personaDTO.getNombre());
		persona.setApellido(personaDTO.getApellido());
		persona.setCorreo(personaDTO.getCorreo());
		DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		try {
			persona.setFechaNacimiento(fecha.parse(personaDTO.getFechaNacimiento()));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		persona.setTelefono(personaDTO.getTelefono());
		persona.setRegion(personaDTO.getRegion());
		persona.setComuna(personaDTO.getComuna());
		return persona;
	}
	public PersonaDTO mapPersona(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		personaDTO.setId(persona.getId());
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setApellido(persona.getApellido());
		personaDTO.setCorreo(persona.getCorreo());
		DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		String fechaNacimiento=fecha.format(persona.getFechaNacimiento());
		personaDTO.setFechaNacimiento(fechaNacimiento);
		personaDTO.setTelefono(persona.getTelefono());
		personaDTO.setRegion(persona.getRegion());
		personaDTO.setComuna(persona.getComuna());
		return personaDTO;
		
	}
}
