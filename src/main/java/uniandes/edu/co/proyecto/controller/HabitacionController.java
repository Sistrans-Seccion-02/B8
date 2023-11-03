package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Habitacion;
import uniandes.edu.co.proyecto.repositories.HabitacionRepository;
import uniandes.edu.co.proyecto.repositories.HotelRepository;
import uniandes.edu.co.proyecto.repositories.TipoHabitacionRepository;

@Controller
public class HabitacionController {
    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        return "habitacion";
    }

    @GetMapping("/habitaciones/new")
    public String habitacionForm(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        model.addAttribute("tiposhabitacion", tipoHabitacionRepository.darTiposHabitacion());
        model.addAttribute("hoteles", hotelRepository.darHoteles());
        return "habitacionNuevo";
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionGuardar(@ModelAttribute Habitacion habitacion) {
        habitacionRepository.insertarHabitacion(habitacion.getNumero(), habitacion.getTipohabitacion().getId(),
                habitacion.getTelevision(), habitacion.getMinibar(), habitacion.getCafetera(),
                habitacion.getDiasestadia(), habitacion.getHotel().getId());
        return "redirect:/habitacion";
    }

    @GetMapping("/habitaciones/{id}/edit")
    public String habitacionEditarForm(@PathVariable("id") long id, Model model) {
        Habitacion habitacion = habitacionRepository.darHabitacion(id);
        if (habitacion != null) {
            model.addAttribute("habitacion", habitacion);
            model.addAttribute("tiposhabitacion", tipoHabitacionRepository.darTiposHabitacion());
            model.addAttribute("hoteles", hotelRepository.darHoteles());
            return "habitacionEditar";
        } else {
            return "redirect:/habitacion";
        }
    }

    @PostMapping("/habitaciones/{id}/edit/save")
    public String habitacionEditarGuardar(@PathVariable("id") long id, @ModelAttribute Habitacion habitacion) {
        habitacionRepository.actualizarHabitacion(id, habitacion.getNumero(), habitacion.getTipohabitacion().getId(),
                habitacion.getTelevision(), habitacion.getMinibar(), habitacion.getCafetera(),
                habitacion.getDiasestadia(), habitacion.getHotel().getId());
        return "redirect:/habitacion";
    }

    @GetMapping("/habitaciones/{id}/delete")
    public String habitacionEliminar(@PathVariable("id") long id) {
        habitacionRepository.eliminarHabitacion(id);
        return "redirect:/habitacion";
    }

}
