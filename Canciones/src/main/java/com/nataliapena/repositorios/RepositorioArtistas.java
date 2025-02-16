package com.nataliapena.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nataliapena.modelos.Artista;

public interface RepositorioArtistas extends CrudRepository<Artista, Long>{
	List<Artista> findAll();
	
}
