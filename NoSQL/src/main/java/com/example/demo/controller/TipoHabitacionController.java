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
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/mongo-tiposhabitacion")
    public String tiposHabitacion(Model model) {
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.findAll());
        return "tipohabitacion";
    }

    @GetMapping("/mongo-tiposhabitacion/new")
    public String tipoHabitacionForm(Model model) {
        model.addAttribute("tipohabitacion", new TipoHabitacion());
        return "tipohabitacionNuevo";
    }

    @PostMapping("/mongo-tiposhabitacion/new/save")
    public String tipoHabitacionGuardar(Model model, @ModelAttribute TipoHabitacion tipoHabitacion) {
        try {
            tipoHabitacionRepository.save(tipoHabitacion);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo guardar el tipo de habitacion. No cumple la validación :(");
        }
        return "redirect:/mongo-tiposhabitacion";
    }

    @GetMapping("/mongo-tiposhabitacion/{id}/edit")
    public String tipoHabitacionEditarForm(@PathVariable("id") String id, Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.buscarPorId(id);
        if (tipoHabitacion != null) {
            model.addAttribute("tipohabitacion", tipoHabitacion);
            return "tipohabitacionEditar";
        } else {
            return "redirect:/mongo-tiposhabitacion";
        }
    }

    @PostMapping("/mongo-tiposhabitacion/{id}/edit/save")
    public String tipoHabitacionEditarGuardar(Model model, @PathVariable("id") String id,
            @ModelAttribute TipoHabitacion tipoHabitacion) {
        try {
            tipoHabitacionRepository.actualizarTipoHabitacion(id, tipoHabitacion.getNombre());
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo actualizar. No cumple la validación :(");
        }
        return "redirect:/mongo-tiposhabitacion";
    }

    @GetMapping("/mongo-tiposhabitacion/{id}/delete")
    public String tipoHabitacionEliminar(@PathVariable("id") String id) {
        tipoHabitacionRepository.eliminarTipoHabitacion(id);
        return "redirect:/mongo-tiposhabitacion";
    }
}