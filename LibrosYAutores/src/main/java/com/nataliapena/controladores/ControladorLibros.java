package com.nataliapena.controladores;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorLibros {
	private static HashMap<String, String> listaLibros = new HashMap<String, String>();
	
	public ControladorLibros() {
		listaLibros.put("Odisea", "Homero");	
		listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
		listaLibros.put("El Código Da Vinci", "Dan Brown");		
		listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
		listaLibros.put("El Hobbit", "J.R.R. Tolkien");	
		listaLibros.put("El alquimista", "Paulo Coelho");	
	}
	
	@GetMapping("/libros/formulario")
	public String formularioLibro() {
		return "formularioLibros.jsp";
	}
	
	@PostMapping("/procesa/libro")
	public String procesaLibro(
			Model model,
			@RequestParam String nombre,
			@RequestParam String autor) {
		listaLibros.put(nombre, autor);
		model.addAttribute("listaLibros", listaLibros);
		return "libros.jsp";
	}
	
	@GetMapping("/libros")
	public String obtenerTodosLosLibros(Model model) {
		model.addAttribute("listaLibros", listaLibros);
		return "libros.jsp";
	}
	
	@GetMapping("/libros/{nombre}")
	public String obtenerInformacionDeLibro(Model model, @PathVariable String nombre) {
		model.addAttribute("nombre", nombre);
		model.addAttribute("libro", listaLibros.get(nombre));
		return "detalleLibro.jsp";
	}
	
}
