package com.nataliapena.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nataliapena.modelos.Usuario;
import com.nataliapena.servicios.ServiciosUsuario;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuario {

	@Autowired
    private ServiciosUsuario usuarioService;

    @GetMapping("/")
    public String inicio() {
        return "index.jsp";
    }

    @PostMapping("/procesa/login")
    public String login(@RequestParam("correo") String correo, 
                       @RequestParam("contraseña") String contraseña,
                       HttpSession session,
                       RedirectAttributes redirectAttributes) {
        
        Usuario usuario = usuarioService.validarLogin(correo, contraseña);
        
        if(usuario != null) {
            session.setAttribute("usuarioId", usuario.getId());
            session.setAttribute("nombreUsuario", usuario.getNombreUsuario());
            return "inicio.jsp";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Credenciales inválidas");
            return "redirect:/";
        }
    }

    @PostMapping("/procesa/registro")
    public String registro(@Valid @ModelAttribute("usuario") Usuario usuario,
                          BindingResult result,
                          RedirectAttributes redirectAttributes) {
        
        if(result.hasErrors()) {
            redirectAttributes.addFlashAttribute("registroError", 
                "Por favor verifica los datos ingresados");
            return "redirect:/";
        }

        try {
            usuarioService.agregarUsuario(usuario);
            redirectAttributes.addFlashAttribute("successMessage", 
                "Registro exitoso. Por favor inicia sesión");
            return "redirect:/";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("registroError", 
                "Error al registrar: " + e.getMessage());
            return "redirect:/";
        }
    }
}
