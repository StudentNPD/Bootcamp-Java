package com.nataliapena.controladores;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControladorRecetas {
	private static String[] listaRecetas = {"Pizza", "Espagueti", "Lasaña"};
	private static HashMap<String, String []> recetasConIngredientes = new HashMap<String, String[]>();
		
	public ControladorRecetas() {
		String [] pizza = {"Pan", "Salsa de tomate", "Queso", "Pepperoni"};
		recetasConIngredientes.put("Pizza", pizza);
		String [] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
		recetasConIngredientes.put("Espagueti", espagueti);
		String [] lasaña = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"};
		recetasConIngredientes.put("Lasaña", lasaña);
	}
	
	@GetMapping("/recetas")
	public String obtenerTodasLasRecetas(Model model) {
		model.addAttribute("listaRecetas",recetasConIngredientes);
		return "recetas.jsp";
	}
	
	@GetMapping("/recetas/{nombre}")
	public String obtenerRecetasPorNombre(Model model, @PathVariable String nombre) {
		model.addAttribute("nombre", nombre);
		model.addAttribute("receta", recetasConIngredientes.get(nombre));
		return "detalleReceta.jsp";
	}
	
	
}
