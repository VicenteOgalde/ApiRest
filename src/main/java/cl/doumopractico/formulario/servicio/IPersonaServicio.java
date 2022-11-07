package cl.doumopractico.formulario.servicio;

import java.util.List;

import cl.doumopractico.formulario.DTO.PersonaDTO;
import cl.doumopractico.formulario.modelo.Persona;

public interface IPersonaServicio {

	public List<PersonaDTO> listarTodos();
	public List<PersonaDTO> listarPorRegion(String region);
	public List<PersonaDTO> listarPorRegionYComuna(String region,String comuna);
	public PersonaDTO crearPersona(PersonaDTO personaDTO);
	public PersonaDTO actualizarPersona(PersonaDTO personaDTO);
	public void eliminarPersona(Long id);
	
	
}
