package cl.doumopractico.formulario.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String nombre;
	private String apellido;
	private String correo;
	private Date fechaNacimiento;
	@Column(length = 50)
	private String telefono;
	@Column(length = 50)
	private String region;
	@Column(length = 50)
	private String comuna;
	@Column(nullable = false, updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	public Persona(String nombre, String apellido, String correo,Date fechaNacimiento,
			String telefono,String region, String comuna) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.correo=correo;
		this.fechaNacimiento=fechaNacimiento;
		this.telefono=telefono;
		this.region=region;
		this.comuna=comuna;
	}
	@PrePersist
	protected void onCreated() {
		this.createdAt= new Date();
	}
	@PreUpdate
	protected void onUpdated() {
		this.updatedAt=new Date();
	}
	

}
