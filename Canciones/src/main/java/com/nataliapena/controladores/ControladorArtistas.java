package com.nataliapena.controladores;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nataliapena.modelos.Artista;
import com.nataliapena.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {
	@Autowired
	ServicioArtistas servicio;

	@GetMapping("/artistas")
	public String desplegarArtistas(Model model) {
		model.addAttribute("artistas", servicio.obtenerTodosLosArtistas());
		return "artistas.jsp";
	}

	@GetMapping("/artistas/detalle/{idArtista}")
	public String desplegarDetalleArtista(Model model, @PathVariable Long idArtista) {
		Artista artista = servicio.obtenerArtistaPorId(idArtista);
		model.addAttribute("artista", servicio.obtenerArtistaPorId(idArtista));
		System.out.println(artista);
		return "detalleArtista.jsp";
	}

	@GetMapping("/artistas/formulario/agregar")
	public String formularioAgregarArtista(Model model) {
		Artista artista = new Artista();
		model.addAttribute("artista", artista);
		System.out.println(artista);
		return "agregarArtista.jsp";
	}

	@PostMapping("/artistas/procesa/agregar")
	public String procesarAgregarArtista(Model model, @Valid @ModelAttribute("artista") Artista artista,
			BindingResult result) {
		if (result.hasErrors()) {
			return "agregarArtista.jsp";
		}
		servicio.agregarArtista(artista);
		return "redirect:/artistas";
	}

	// Mostrar formulario de edición
	@GetMapping("/artistas/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {

		Artista artista = servicio.obtenerArtistaPorId(id);
		model.addAttribute("artista", artista);
		return "editarArtista.jsp";

	}

	// Procesar la actualización
	@PostMapping("/artistas/actualizar/{id}")
	public String actualizarArtista(@PathVariable Long id, @Valid @ModelAttribute("artista") Artista artista,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "editarArtista.jsp";
		}

		servicio.actualizarArtista(id, artista);
		return "redirect:/artistas";

	}
	
	@GetMapping("/artistas/eliminar/{id}")
	public String procesarEliminarArtistas(@PathVariable Long id) {
		servicio.eliminaArtista(id);
		return "redirect:/artistas";
	}
}