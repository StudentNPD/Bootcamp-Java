package com.nataliapena.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.nataliapena.servicios.ServicioCanciones;

@Controller
public class ControladorCanciones {
	@Autowired
	ServicioCanciones servicio;
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model model) {
		model.addAttribute("canciones", servicio.obtenerTodasLasCanciones());
		return "canciones.jsp";
	}
	
	@GetMapping("/canciones/detalle/{idCancion}")
	public String desplegarDetalleCancion(Model model, @PathVariable Long idCancion) {
		model.addAttribute("cancion", servicio.obtenerCancionPorId(idCancion));
		return "detalleCancion.jsp";
	}
	
	
	
	
}
