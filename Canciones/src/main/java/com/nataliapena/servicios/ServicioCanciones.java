package com.nataliapena.servicios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nataliapena.modelos.Cancion;
import com.nataliapena.repositorios.RepositorioCanciones;

import jakarta.validation.Valid;

@Service
public class ServicioCanciones {
	@Autowired
	// RepositorioCanciones.java importado
	RepositorioCanciones repositorio;

	// Metodo public retorna una lista de canciones
	public List<Cancion> obtenerTodasLasCanciones() {
		return repositorio.findAll();
	}

	public Cancion obtenerCancionPorId(Long id) {
		// orelse null es por si no encuentra el id
		return repositorio.findById(id).orElse(null);
	}
	
	public Cancion agregarCancion(Cancion cancion) {
		return repositorio.save(cancion);
	}

	public Cancion actualizarCancion(Long id, @Valid Cancion cancion) {
		Cancion cancionExistente = repositorio.findById(id).orElse(null);
		
		cancionExistente.setTitulo(cancion.getTitulo());
		cancionExistente.setArtista(cancion.getArtista());
		cancionExistente.setAlbum(cancion.getAlbum());
		cancionExistente.setGenero(cancion.getGenero());
		cancionExistente.setIdioma(cancion.getIdioma());
		
		cancionExistente.setFechaActualizacion(new Date());
		
		return repositorio.save(cancionExistente);
		
	}
	

	
	
}
