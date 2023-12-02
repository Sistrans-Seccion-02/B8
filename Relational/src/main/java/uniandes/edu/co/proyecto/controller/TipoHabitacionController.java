package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.TipoHabitacion;
import uniandes.edu.co.proyecto.repositories.TipoHabitacionRepository;

import org.springframework.ui.Model;

@Controller
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/tiposHabitacion")
    public String tiposHabitacion(Model model) {
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.darTiposHabitacion());
        return "tipohabitacion";
    }

    @GetMapping("/tiposHabitacion/new")
    public String tipoHabitacionForm(Model model) {
        model.addAttribute("tipohabitacion", new TipoHabitacion());
        return "tipohabitacionNuevo";
    }

    @PostMapping("/tiposHabitacion/new/save")
    public String tipoHabitacionGuardar(@ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.insertarTipoHabitacion(tipoHabitacion.getNombre());
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/{id}/edit")
    public String tipoHabitacionEditarForm(@PathVariable("id") long id, Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.darTipoHabitacion(id);
        if (tipoHabitacion != null) {
            model.addAttribute("tipohabitacion", tipoHabitacion);
            return "tipohabitacionEditar";
        } else {
            return "redirect:/tiposHabitacion";
        }
    }

    @PostMapping("/tiposHabitacion/{id}/edit/save")
    public String tipoHabitacionEditarGuardar(@PathVariable("id") long id,
            @ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.actualizarTipoHabitacion(id, tipoHabitacion.getNombre());
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/{id}/delete")
    public String tipoHabitacionEliminar(@PathVariable("id") long id) {
        tipoHabitacionRepository.eliminarTipoHabitacion(id);
        return "redirect:/tiposHabitacion";
    }

}
