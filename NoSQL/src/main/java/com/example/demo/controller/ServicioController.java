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
public class ServicioController {
    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/mongo-servicios")
    public String servicios(Model model) {
        model.addAttribute("servicios", servicioRepository.findAll());
        return "servicio";
    }

    @GetMapping("/mongo-servicios/new")
    public String servicioForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicioNuevo";
    }

    @PostMapping("/mongo-servicios/new/save")
    public String servicioGuardar(Model model, @ModelAttribute Servicio servicio) {
        try {
            servicioRepository.save(servicio);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo guardar el servicio. No cumple la validación :(");
        }
        return "redirect:/mongo-servicios";
    }

    @GetMapping("/mongo-servicios/{id}/edit")
    public String servicioEditarForm(@PathVariable("id") String id, Model model) {
        Servicio servicio = servicioRepository.buscarPorId(id);
        if (servicio != null) {
            model.addAttribute("servicio", servicio);
            return "servicioEditar";
        } else {
            return "redirect:/mongo-servicios";
        }
    }

    @PostMapping("/mongo-servicios/{id}/edit/save")
    public String servicioEditarGuardar(Model model, @PathVariable("id") String id,
            @ModelAttribute Servicio servicio) {
        try {
            servicioRepository.actualizarServicio(id, servicio.getNombre(), servicio.getCapacidad(), servicio.getCostoDanios());
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo guardar el servicio. No cumple la validación :(");
        }
        return "redirect:/mongo-servicios";
    }

    @GetMapping("/mongo-servicios/{id}/delete")
    public String servicioBorrar(Model model, @PathVariable("id") String id) {
        try {
            servicioRepository.deleteById(id);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo borrar el servicio. No cumple la validación :(");
        }
        return "redirect:/mongo-servicios";
    }
    
}
