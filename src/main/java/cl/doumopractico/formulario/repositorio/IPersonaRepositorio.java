package cl.doumopractico.formulario.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.doumopractico.formulario.modelo.Persona;

public interface IPersonaRepositorio extends JpaRepository<Persona, Long>{

	public List<Persona> findByRegion(String region);
	public List<Persona> findByRegionAndComuna(String region,String comuna);
}
