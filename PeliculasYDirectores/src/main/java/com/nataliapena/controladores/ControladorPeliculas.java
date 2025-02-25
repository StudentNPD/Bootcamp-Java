package com.nataliapena.controladores;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPeliculas {
	private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();

	public ControladorPeliculas() {
		listaPeliculas.put("Winnie the Pooh", "Don Hall");	
		listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
		listaPeliculas.put("Tarzán", "Kevin Lima");		
		listaPeliculas.put("Mulán", "Barry Cook");
		listaPeliculas.put("Oliver", "Kevin Lima");	
		listaPeliculas.put("Big Hero 6", "Don Hall");	
	}
	@GetMapping("/peliculas")
	public String obtenerTodasLasPeliculas() {
		return listaPeliculas.toString();
	}
	
	@GetMapping("/peliculas/{nombre}")
	public String obtenerPeliculaPorNombre(@PathVariable("nombre") String nombre) {
		String resultado = "";
		resultado = listaPeliculas.get(nombre);
		if(resultado == null) {
			resultado = "La pelicula no se encuentra en esta lista";
		}else {
			resultado = "Director: " + resultado + " " + " Pelicula: " + nombre;
		}
		return resultado;	
	}
	
	@GetMapping("/peliculas/director/{nombre}")
	public String obtenerPeliculaPorDirector(@PathVariable("nombre") String nombre) {
		String resultado = "";
		for(Map.Entry<String, String> entry: listaPeliculas.entrySet()) {
			if(Objects.equals(nombre, entry.getValue())) {
				
				resultado += entry.getKey() + " ";
			}
		}
		if(resultado.equals("")) {
			resultado = "No contamos con peliculas de ese director en nuestra lista";
		}
		return resultado;
	}
	
	
	
}

