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
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/mongo-reservas")
    public String reservas(Model model) {
        model.addAttribute("reservas", reservaRepository.findAll());
        return "reserva";
    }

    @GetMapping("/mongo-reservas/new")
    public String reservaForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        return "reservaNuevo";
    }

    @PostMapping("/mongo-reservas/new/save")
    public String reservaGuardar(Model model, @ModelAttribute Reserva reserva) {
        try {
            reservaRepository.save(reserva);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo guardar la reserva. No cumple la validación :(");
        }
        return "redirect:/mongo-reservas";
    }

    @GetMapping("/mongo-reservas/{id}/edit")
    public String reservaEditarForm(@PathVariable("id") String id, Model model) {
        Reserva reserva = reservaRepository.buscarPorId(id);
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            model.addAttribute("usuarios", usuarioRepository.findAll());
            model.addAttribute("habitaciones", habitacionRepository.findAll());
            return "reservaEditar";
        } else {
            return "redirect:/mongo-reservas";
        }
    }

    @PostMapping("/mongo-reservas/{id}/edit/save")
    public String reservaEditarGuardar(Model model, @PathVariable("id") String id,
            @ModelAttribute Reserva reserva) {
        try {
            reservaRepository.actualizarReserva(id, reserva.getCostoTotal(), reserva.getFecha_inicio(), reserva.getFecha_fin(), reserva.getPlanes_estadia(), reserva.getUsuario().getId(), reserva.getHabitacion().getNumero());
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo actualizar la reserva. No cumple la validación :(");
        }
        return "redirect:/mongo-reservas";
    }

    @GetMapping("/mongo-reservas/{id}/delete")
    public String reservaEliminar(@PathVariable("id") String id) {
        reservaRepository.eliminarReserva(id);
        return "redirect:/mongo-reservas";
    }

    @GetMapping("mongo-reservas/{id}/checkin")
    public String reservaCheckin(@PathVariable("id") String id, Model model) {
        Reserva reserva = reservaRepository.buscarPorId(id);
        if (reserva != null) {
            if (reserva.getEstado().equals("RESERVADO")) {
                reservaRepository.actualizarEstado(id, "HOSPEDADO");
                return "redirect:/mongo-reservas?cedula=" + reserva.getUsuario().getCedula() + "";
            } else {
                model.addAttribute("error", "No fue posible hacer el check-in del cliente");
                return "redirect:/mongo-reservas?cedula=" + reserva.getUsuario().getCedula() + "";
            }
        } else {
            model.addAttribute("error", "No se encontraron reservas para esa cédula");
            return "redirect:/reservas";
        }
    }

    @GetMapping("mongo-reservas/{id}/checkout")
    public String reservaCheckout(@PathVariable("id") String id, Model model) {
        Reserva reserva = reservaRepository.buscarPorId(id);
        if (reserva != null) {
            if (reserva.getEstado().equals("HOSPEDADO")) {
                reservaRepository.actualizarEstado(id, "CHECK-OUT");
                return "redirect:/mongo-reservas?cedula=" + reserva.getUsuario().getCedula() + "";
            } else {
                model.addAttribute("error", "No fue posible hacer el check-out del cliente");
                return "redirect:/mongo-reservas?cedula=" + reserva.getUsuario().getCedula() + "";
            }
        } else {
            model.addAttribute("error", "No se encontraron reservas para esa cédula");
            return "redirect:/reservas";
        }
    }
    
}
