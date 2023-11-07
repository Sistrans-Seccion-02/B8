package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.model.Usuario;
import uniandes.edu.co.proyecto.repositories.UsuarioRepository;

@Controller
public class LoginController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public String login(Model model, @RequestParam("correo") String correo, @RequestParam("password") String password) {
        Usuario usuario = usuarioRepository.darUsuarioPorCorreo(correo);
        
        try {
            String contraseniaReal = usuario.getPassword();
            if (contraseniaReal.equals(password)) {
                return "redirect:/" + usuario.getTipousuario().getNombre().toLowerCase();
            } 
            else {
                model.addAttribute("error", "Contraseña o Usuario incorrecto, intente de nuevo");
                return "menuPrincipal";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Contraseña o Usuario incorrecto, intente de nuevo");
            return "menuPrincipal";
        }
    }
    
}
