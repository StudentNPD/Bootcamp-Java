package com.nataliapena.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.nataliapena.modelos.Usuario;

public interface RepositorioUsuarios  extends CrudRepository<Usuario, Long>{
	Usuario getByCorreo(String correo);
}
