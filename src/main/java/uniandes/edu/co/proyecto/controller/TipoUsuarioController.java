package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.TipoUsuario;
import uniandes.edu.co.proyecto.repositories.TipoUsuarioRepository;

@Controller
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/tiposUsuario")
    public String tiposUsuario(Model model) {
        model.addAttribute("tiposusuario", tipoUsuarioRepository.darTiposUsuario());
        return "tipousuario";
    }

    @GetMapping("/tiposUsuario/new")
    public String tipoUsuarioForm(Model model) {
        model.addAttribute("tipousuario", new TipoUsuario());
        return "tipousuarioNuevo";
    }

    @PostMapping("/tiposUsuario/new/save")
    public String tipoUsuarioGuardar(@ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.insertarTipoUsuario(tipoUsuario.getNombre());
        System.out.println(tipoUsuario.getNombre());
        return "redirect:/tiposUsuario";
    }

    @GetMapping("/tiposUsuario/{id}/edit")
    public String tipoUsuarioEditarForm(@PathVariable("id") long id, Model model) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.darTipoUsuario(id);
        if (tipoUsuario != null) {
            model.addAttribute("tipousuario", tipoUsuario);
            return "tipousuarioEditar";
        } else {
            return "redirect:/tiposUsuario";
        }
    }

    @PostMapping("/tiposUsuario/{id}/edit/save")
    public String tipoUsuarioEditarGuardar(@PathVariable("id") long id, @ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.actualizarTipoUsuario(id, tipoUsuario.getNombre());
        return "redirect:/tiposUsuario";
    }

    @GetMapping("/tiposUsuario/{id}/delete")
    public String tipoUsuarioBorrar(@PathVariable("id") long id) {
        tipoUsuarioRepository.eliminarTipoUsuario(id);
        return "redirect:/tiposUsuario";
    }

}
