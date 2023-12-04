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
public class ConsumoController {
    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/mongo-consumos")
    public String consumos(Model model) {
        model.addAttribute("consumos", consumoRepository.findAll());
        return "consumo";
    }

    @GetMapping("/mongo-consumos/new")
    public String consumoForm(Model model) {
        model.addAttribute("consumo", new Consumo());
        model.addAttribute("servicios", servicioRepository.findAll());
        return "consumoNuevo";
    }

    @PostMapping("/mongo-consumos/new/save")
    public String consumoGuardar(Model model, @ModelAttribute Consumo consumo) {
        try {
            consumoRepository.save(consumo);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo guardar el consumo. No cumple la validación :(");
        }
        return "redirect:/mongo-consumos";
    }

    @GetMapping("/mongo-consumos/{id}/edit")
    public String consumoEditarForm(@PathVariable("id") String id, Model model) {
        Consumo consumo = consumoRepository.buscarPorId(id);
        if (consumo != null) {
            model.addAttribute("consumo", consumo);
            model.addAttribute("servicios", servicioRepository.findAll());
            return "consumoEditar";
        } else {
            return "redirect:/mongo-consumos";
        }
    }

    @PostMapping("/mongo-consumos/{id}/edit/save")
    public String consumoEditarGuardar(@PathVariable("id") String id, Model model, @ModelAttribute Consumo consumo) {
        try {
            consumoRepository.actualizarConsumo(id, consumo.getFecha(), consumo.getValorTotal(), consumo.getServicios().get(0).getId());
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo actualizar el consumo. No cumple la validación :(");
        }
        return "redirect:/mongo-consumos";
    }

    @GetMapping("/mongo-consumos/{id}/delete")
    public String consumoEliminar(@PathVariable("id") String id, Model model) {
        try {
            consumoRepository.eliminarConsumo(id);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo eliminar el consumo. No cumple la validación :(");
        }
        return "redirect:/mongo-consumos";
    }
    
}
