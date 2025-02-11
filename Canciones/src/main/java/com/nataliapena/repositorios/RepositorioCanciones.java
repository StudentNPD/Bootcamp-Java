package com.nataliapena.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nataliapena.modelos.Cancion;

// Creando interfaz para hacer el repositorio canciones
@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long>{

	// Retornar una lista de canciones
	List<Cancion> findAll();
	
}
