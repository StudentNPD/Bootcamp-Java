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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "canciones")
public class Cancion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 	 // Agregando anotación para validar la longitud de un string  
	
	@NotBlank(message = "El título no puede estar vacío")
    @Size(min = 5, message = "El título debe tener al menos 5 caracteres")
    private String titulo;

    @NotBlank(message = "El artista no puede estar vacío")
    @Size(min = 3, message = "El nombre del artista debe tener al menos 3 caracteres")
    private String artista;

    @NotBlank(message = "El álbum no puede estar vacío")
    @Size(min = 3, message = "El nombre del álbum debe tener al menos 3 caracteres")
    private String album;

    @NotBlank(message = "El género no puede estar vacío")
    @Size(min = 3, message = "El género debe tener al menos 3 caracteres")
    private String genero;

    @NotBlank(message = "El idioma no puede estar vacío")
    @Size(min = 3, message = "El idioma debe tener al menos 3 caracteres")
    private String idioma;
	
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "fecha_creacion")
	private Date fechaCreacion;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;
	
	
	
	// Getters y setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
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
	// Metodos marcados con las anotaciones de los ciclos de vida
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
