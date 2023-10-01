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

@Controller
public class HabitacionController {
    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        return "habitaciones";
    }

    @GetMapping("/habitaciones/new")
    public String habitacionForm(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        return "habitacionNueva";
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionGuardar(@ModelAttribute Habitacion habitacion) {
        habitacionRepository.insertarHabitacion(habitacion.getNumero(), habitacion.getTipoHabitacion(), habitacion.getPlan(), habitacion.getTelevision(), habitacion.getMinibar(), habitacion.getCafetera(), habitacion.getDiasEstadia());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{numero}/edit")
    public String habitacionEditarForm(@PathVariable("numero") Integer numero, Model model) {
        Habitacion habitacion = habitacionRepository.darHabitacion(numero);
        if (habitacion != null) {
            model.addAttribute("habitacion", habitacion);
            return "habitacionEditar";
        } else {
            return "redirect:/habitaciones";
        }
    }

    @PostMapping("/habitaciones/{numero}/edit/save")
    public String habitacionEditarGuardar(@PathVariable("numero") Integer numero, @ModelAttribute Habitacion habitacion) {
        habitacionRepository.actualizarHabitacion(numero, habitacion.getTipoHabitacion(), habitacion.getPlan(), habitacion.getTelevision(), habitacion.getMinibar(), habitacion.getCafetera(), habitacion.getDiasEstadia());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{numero}/delete")
    public String habitacionEliminar(@PathVariable("numero") Integer numero) {
        habitacionRepository.eliminarHabitacion(numero);
        return "redirect:/habitaciones";
    }

}

