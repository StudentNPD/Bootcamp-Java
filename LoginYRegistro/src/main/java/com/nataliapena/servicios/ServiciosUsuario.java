package com.nataliapena.servicios;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nataliapena.modelos.Usuario;
import com.nataliapena.repositorios.RepositorioUsuarios;

@Service
public class ServiciosUsuario {

	@Autowired
	RepositorioUsuarios repositorio;
	
	public List<Usuario> obtenerUsuarios() {
		return (List<Usuario>) repositorio.findAll();
	}
	
	public void agregarUsuario(Usuario usuario) {
		usuario.setContraseña(BCrypt.hashpw(usuario.getContraseña(), BCrypt.gensalt()));
		repositorio.save(usuario);
		System.out.println(usuario);
	}
	
	public Usuario validarLogin(String correo, String password) {
		Usuario usuarioExistente = this.repositorio.getByCorreo(correo);
		if(usuarioExistente == null) {
			return null;
		}
		else {
			if(! BCrypt.checkpw(password, usuarioExistente.getContraseña())) {
				return null;
			}
		}
			
		return usuarioExistente;
	}
}