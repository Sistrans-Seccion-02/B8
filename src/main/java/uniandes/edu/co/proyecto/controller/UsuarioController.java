package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Usuario;
import uniandes.edu.co.proyecto.repositories.UsuarioRepository;

import org.springframework.ui.Model;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario) {
        usuarioRepository.insertarUsuario(usuario.getCedula(), usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getTipoUsuario(), usuario.getPassword(), usuario.getNumAcompañantes(), usuario.getAreaEmpleado());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{cedula}/edit")
    public String usuarioEditarForm(@PathVariable("cedula") Integer cedula, Model model) {
        Usuario usuario = usuarioRepository.darUsuario(cedula);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{cedula}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("cedula") Integer cedula, @ModelAttribute Usuario usuario) {
        usuarioRepository.actualizarUsuario(cedula, usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getTipoUsuario(), usuario.getPassword(), usuario.getNumAcompañantes(), usuario.getAreaEmpleado());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/delete")
    public String usuarioEliminar(@PathVariable("id") Integer id) {
        usuarioRepository.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

}