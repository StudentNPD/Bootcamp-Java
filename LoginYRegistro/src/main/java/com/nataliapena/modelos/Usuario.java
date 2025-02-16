package com.nataliapena.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {


	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;

	   @NotBlank(message = "Por favor proporciona el nombre de usuario.")
	   @Size(min = 3, max = 15, message = "El nombre de usuario debe de contener entre 3 y 15 caracteres.")
	   private String nombreUsuario;

	   @NotBlank(message = "Por favor proporciona la constraseña.")
	   @Size(min = 8, message = "El password necesita tener al menos 8 catacteres.")
	   @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "El password necesita incluir al menos una letra mayúscula, una letra minúscula y un número")
	   private String contraseña;

	   @NotBlank(message = "El correo es requerido.")
	   @Email(message = "Por favor proporciona un correo válido.")
	   private String correo;

	   @NotBlank(message = "Por favor proporciona tu nombre")
	   @Size(min = 3, message = "Por favor propociona tu nombre")
	   private String nombre;
	  
	   @NotBlank(message = "Por favor proporciona tu apellido")
	   @Size(min = 3, message = "Por favor propociona tu apellido")
	   private String apellido;

	   @Past(message = "Tu fecha de nacimiento necesita ser una fecha en el pasado.")
	   @DateTimeFormat(pattern="yyyy-MM-dd")
	   @Temporal(TemporalType.DATE)
	   private Date fechaDeNacimiento;
	  
	   @Column(updatable=false)
	   @DateTimeFormat(pattern="yyyy-MM-dd")
	   private Date fechaCreacion;

	   @DateTimeFormat(pattern="yyyy-MM-dd")
	   private Date fechaActualizacion;
	   
	   

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	   
	
	@PrePersist
	protected void onCreate() {
		this.fechaCreacion = new Date();
		this.fechaActualizacion = this.fechaCreacion;
	}

	@PreUpdate
	protected void onUpdate() {
		this.fechaActualizacion = new Date();
	}
	   
	   
}