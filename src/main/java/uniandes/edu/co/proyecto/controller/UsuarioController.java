package uniandes.edu.co.proyecto.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.model.Usuario;
import uniandes.edu.co.proyecto.repositories.TipoUsuarioRepository;
import uniandes.edu.co.proyecto.repositories.UsuarioRepository;

import org.springframework.ui.Model;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/consultarConsumo")
    public String consultarConsumo(
            @RequestParam("fechainicio") Date fechaInicio,
            @RequestParam("fechafin") Date fechaFin,
            @RequestParam("nombreservicio") String nombreServicio,
            Model model) {

        List<Object[]> resultados = usuarioRepository.consultarConsumoNative(fechaInicio, fechaFin, nombreServicio);

        // Agregar resultados al modelo
        model.addAttribute("resultados", resultados);
        return "formularioConsultarConsumo";

    }

    @GetMapping("/consultarSinConsumo")
    public String consultarSinConsumo(
            @RequestParam("fechainicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam("fechafin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin,
            @RequestParam("servicionombre") String nombreServicio,
            Model model) {

    List<Object[]> resultados = usuarioRepository.consultarUsuariosSinConsumoNative(fechaInicio, fechaFin, nombreServicio);

    // Agregar resultados directamente al modelo
    model.addAttribute("resultados", resultados);
    return "formularioConsultarNoConsumo";
}


    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("tiposusuario", tipoUsuarioRepository.darTiposUsuario());
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario) {
        usuarioRepository.insertarUsuario(usuario.getCedula(), usuario.getNombre(), usuario.getApellido(),
                usuario.getCorreo(), usuario.getTipousuario().getId(), usuario.getPassword(),
                usuario.getNumacompaniantes(), usuario.getAreaempleado());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") long id, Model model) {
        Usuario usuario = usuarioRepository.darUsuario(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("tiposusuario", tipoUsuarioRepository.darTiposUsuario());
            return "usuarioEditar";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") long id, @ModelAttribute Usuario usuario) {
        usuarioRepository.actualizarUsuario(id, usuario.getCedula(), usuario.getNombre(), usuario.getApellido(),
                usuario.getCorreo(), usuario.getTipousuario().getId(), usuario.getPassword(),
                usuario.getNumacompaniantes(), usuario.getAreaempleado());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/delete")
    public String usuarioEliminar(@PathVariable("id") long id) {
        usuarioRepository.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

}
