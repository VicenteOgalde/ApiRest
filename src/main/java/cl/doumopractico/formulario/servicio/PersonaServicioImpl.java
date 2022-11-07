package cl.doumopractico.formulario.servicio;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import cl.doumopractico.formulario.DTO.PersonaDTO;
import cl.doumopractico.formulario.exceptions.PersonaException;
import cl.doumopractico.formulario.mapper.PersonaDTOEntradaPersonaSalida;
import cl.doumopractico.formulario.modelo.Persona;
import cl.doumopractico.formulario.repositorio.IPersonaRepositorio;

@Service
public class PersonaServicioImpl implements IPersonaServicio {

	private final IPersonaRepositorio personaRepositorio;
	private final PersonaDTOEntradaPersonaSalida personaMapper;

	public PersonaServicioImpl(IPersonaRepositorio personaRepositorio, PersonaDTOEntradaPersonaSalida personaMapper) {
		this.personaRepositorio = personaRepositorio;
		this.personaMapper = personaMapper;
	}

	@Override
	public List<PersonaDTO> listarTodos() {
		List<PersonaDTO>personas= personaRepositorio.findAll().stream().
				map(persona -> personaMapper.mapPersona(persona)).collect(Collectors.toList());
		return personas;
	}

	@Override
	public List<PersonaDTO> listarPorRegion(String region) {
		List<PersonaDTO>personas=personaRepositorio.findByRegion(region).stream().
				map(persona -> personaMapper.mapPersona(persona)).collect(Collectors.toList());
		return personas;
	}

	@Override
	public List<PersonaDTO> listarPorRegionYComuna(String region,String comuna) {
		List<PersonaDTO> personas=personaRepositorio.findByRegionAndComuna(region, comuna).
				stream().map(persona -> personaMapper.mapPersona(persona)).collect(Collectors.toList()) ;
		return personas;
	}

	@Override
	public PersonaDTO crearPersona(PersonaDTO personaDTO) {
		Persona persona=personaRepositorio.save(personaMapper.map(personaDTO));
		return personaMapper.mapPersona(persona);
	}

	@Override
	@Transactional
	public PersonaDTO actualizarPersona(PersonaDTO personaDTO) {

		Persona persona = personaRepositorio.findById(personaDTO.getId()).orElseThrow(()->
		new PersonaException("Persona no encontrada", HttpStatus.NOT_FOUND));
		persona=personaMapper.mapEditar(persona,personaDTO);
		
		return personaMapper.mapPersona(personaRepositorio.save(persona));
		
	}

	@Override
	public void eliminarPersona(Long id) {
		personaRepositorio.deleteById(id);

	}

}
