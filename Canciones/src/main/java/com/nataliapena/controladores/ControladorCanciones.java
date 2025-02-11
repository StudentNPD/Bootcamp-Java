package com.nataliapena.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nataliapena.modelos.Cancion;
import com.nataliapena.servicios.ServicioCanciones;

import jakarta.validation.Valid;

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

	@GetMapping("/canciones/formulario/agregar")
	public String formularioAgregarCancion(Model model) {
		model.addAttribute("cancion", new Cancion());
		return "agregarCancion.jsp";

	}

	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(Model model,
			// Valida el modelo min size 3
			@Valid @ModelAttribute("cancion") Cancion cancion,
			// guarda errores en resultado
			BindingResult result) {
		if (result.hasErrors()) {
			return "agregarCancion.jsp";
		}
		servicio.agregarCancion(cancion);
		return "redirect:/canciones";
	}

}
