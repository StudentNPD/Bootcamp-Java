package com.nataliapena.servicios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nataliapena.modelos.Artista;
import com.nataliapena.modelos.Cancion;
import com.nataliapena.repositorios.RepositorioArtistas;
import com.nataliapena.repositorios.RepositorioCanciones;

import jakarta.validation.Valid;

@Service
public class ServicioArtistas {
	@Autowired
	// RepositorioCanciones.java importado
	RepositorioArtistas repositorio;

	// Metodo public retorna una lista de Artistas
	public List<Artista> obtenerTodosLosArtistas() {
		return repositorio.findAll();
	}

	public Artista obtenerArtistaPorId(Long id) {
		// orelse null es por si no encuentra el id
		return repositorio.findById(id).orElse(null);
	}
	
	public Artista agregarArtista(Artista artista) {
		return repositorio.save(artista);
	}

	public Artista actualizarArtista(Long id, @Valid Artista artista) {
		Artista artistaExistente = repositorio.findById(id).orElse(null);
		
        artistaExistente.setNombre(artista.getNombre());
        artistaExistente.setApellido(artista.getApellido());
        artistaExistente.setBiografia(artista.getBiografia());
		
		artistaExistente.setFechaActualizacion(new Date());
		
		return repositorio.save(artistaExistente);
		
	}
	
	public void eliminaArtista(Long id) {
		repositorio.deleteById(id);
	}
}
