package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.*;
import com.example.demo.repositorio.*;

@Controller
public class HabitacionController {
    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/mongo-habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        return "habitacion";
    }

    @GetMapping("/mongo-habitaciones/new")
    public String habitacionForm(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.findAll());
        return "habitacionNuevo";
    }

    @PostMapping("/mongo-habitaciones/new/save")
    public String habitacionGuardar(Model model, @ModelAttribute Habitacion habitacion) {
        try {
            habitacionRepository.save(habitacion);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo guardar la habitacion. No cumple la validación :(");
        }
        return "redirect:/mongo-habitaciones";
    }

    @GetMapping("/mongo-habitaciones/{id}/edit")
    public String habitacionEditarForm(@PathVariable("id") String id, Model model) {
        Habitacion habitacion = habitacionRepository.buscarPorId(id);
        if (habitacion != null) {
            model.addAttribute("habitacion", habitacion);
            model.addAttribute("tiposHabitacion", tipoHabitacionRepository.findAll());
            return "habitacionEditar";
        } else {
            return "redirect:/mongo-habitaciones";
        }
    }

    @PostMapping("/mongo-habitaciones/{id}/edit/save")
    public String habitacionEditarGuardar(Model model, @PathVariable("id") String id,
            @ModelAttribute Habitacion habitacion) {
        try {
            habitacionRepository.actualizarHabitacion(id, habitacion.getNumero(), habitacion.getTipoHabitacion().getId(),
                    habitacion.getTelevision(), habitacion.getMinibar(), habitacion.getCafetera(),
                    habitacion.getDiasEstadia(), habitacion.getIdHotel());
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo actualizar. No cumple la validación :(");
        }
        return "redirect:/mongo-habitaciones";
    }

    @GetMapping("/mongo-habitaciones/{id}/delete")
    public String habitacionEliminar(@PathVariable("id") String id) {
        habitacionRepository.eliminarHabitacion(id);
        return "redirect:/mongo-habitaciones";
    }
    
}
