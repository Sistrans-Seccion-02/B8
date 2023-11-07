package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Servicio;
import uniandes.edu.co.proyecto.repositories.ServicioRepository;

import org.springframework.ui.Model;

@Controller
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicios")
    public String servicios(Model model) {
        model.addAttribute("services", servicioRepository.darServicios());
        for (Servicio servicio : servicioRepository.darServicios()) {
            System.out.println(servicio.getNombre());
        }
        return "servicios";
    }

    @GetMapping("/servicios/new")
    public String servicioForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicioNuevo";
    }

    @PostMapping("/servicios/new/save")
    public String servicioGuardar(@ModelAttribute Servicio servicio) {
        servicioRepository.insertarServicio(servicio.getCapacidad(), servicio.getNombre(),
                servicio.getHotel().getId(), servicio.getClase());
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/edit")
    public String servicioEditarForm(@PathVariable("id") Integer id, Model model) {
        Servicio servicio = servicioRepository.darServicio(id);
        if (servicio != null) {
            model.addAttribute("servicio", servicio);
            return "servicioEditar";
        } else {
            return "redirect:/servicios";
        }
    }

    @PostMapping("/servicios/{id}/edit/save")
    public String servicioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Servicio servicio) {
        servicioRepository.actualizarServicio(id, servicio.getCapacidad(), servicio.getNombre(), servicio.getHotel().getId());
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/delete")
    public String servicioEliminar(@PathVariable("id") Integer id) {
        servicioRepository.eliminarServicio(id);
        return "redirect:/servicios";
    }

}
