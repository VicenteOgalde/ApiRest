package cl.doumopractico.formulario.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.doumopractico.formulario.DTO.PersonaDTO;
import cl.doumopractico.formulario.modelo.Persona;
import cl.doumopractico.formulario.servicio.PersonaServicioImpl;

@RestController
@RequestMapping("/persona")
public class PersonaControlador {
	
	private final PersonaServicioImpl personaServicio;
	
	public PersonaControlador(PersonaServicioImpl personaServicio) {
		this.personaServicio=personaServicio;
	}
	@GetMapping("/todas")
	public ResponseEntity<List<PersonaDTO>> listarTodasLasPersonas(){
		return  new ResponseEntity<>(personaServicio.listarTodos(),HttpStatus.OK);
	}
	@GetMapping("/{region}")
	public ResponseEntity<List<PersonaDTO>> listarPersonasPorRegion(@PathVariable("region") String region){
		return new ResponseEntity<>(personaServicio.listarPorRegion(region),HttpStatus.OK);
		
	}
	@GetMapping("/{region}/{comuna}")
	public ResponseEntity<List<PersonaDTO>> listarPersonasPorComuna(@PathVariable("region") String region,@PathVariable("comuna") String comuna){
		return new ResponseEntity<>(personaServicio.listarPorRegionYComuna(region,comuna),HttpStatus.OK);
	}
	@PostMapping("/crear")
	public ResponseEntity<PersonaDTO>crearPersona(@Valid@RequestBody PersonaDTO personaDTO){
		return new ResponseEntity<>(personaServicio.crearPersona(personaDTO),HttpStatus.CREATED);
	}
	@PutMapping("/editar")
	public ResponseEntity<PersonaDTO> actualizarPersona(@Valid@RequestBody PersonaDTO personaDTO){
		return new ResponseEntity<>(personaServicio.actualizarPersona(personaDTO),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarPersona(@PathVariable("id")Long id){
		personaServicio.eliminarPersona(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
		
}
