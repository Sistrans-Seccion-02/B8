package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.proyecto.model.TipoUsuario;
import uniandes.edu.co.proyecto.repositories.TipoUsuarioRepository;

import org.springframework.ui.Model;

@Controller
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/tiposUsuario")
    public String tiposUsuario(Model model) {
        model.addAttribute("tiposUsuario", tipoUsuarioRepository.darTiposUsuario());
        System.out.println(tipoUsuarioRepository.darTiposUsuario());
        return "tiposUsuario";
    }

    @GetMapping("/tiposUsuario/new")
    public String tipoUsuarioForm(Model model) {
        model.addAttribute("tipoUsuario", new TipoUsuario());
        return "tiposUsuarioNuevo";
    }

    @PostMapping("/tiposUsuario/new/save")
    public String tipoUsuarioGuardar(@ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.insertarTipoUsuario(tipoUsuario.getTipoUsuario());
        return "redirect:/tiposUsuario";
    }

    @GetMapping("/tiposUsuario/{id}/edit")
    public String tipoUsuarioEditarForm(@PathVariable("id") Integer id, Model model) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.darTipoUsuario(id);
        if (tipoUsuario != null) {
            model.addAttribute("tipoUsuario", tipoUsuario);
            return "tiposUsuarioEditar";
        } else {
            return "redirect:/tiposUsuario";
        }
    }

    @PostMapping("/tiposUsuario/{id}/edit/save")
    public String tipoUsuarioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.actualizarTipoUsuario(id, tipoUsuario.getTipoUsuario());
        return "redirect:/tiposUsuario";
    }

    @GetMapping("/tiposUsuario/{id}/delete")
    public String tipoUsuarioEliminar(@PathVariable("id") Integer id) {
        tipoUsuarioRepository.eliminarTipoUsuario(id);
        return "redirect:/tiposUsuario";
    }

}
