package uniandes.edu.co.proyecto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Reserva;
import uniandes.edu.co.proyecto.repositories.PlanEstadiaRepository;
import uniandes.edu.co.proyecto.repositories.ReservaRepository;

import org.springframework.ui.Model;

@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private PlanEstadiaRepository planEstadiaRepository;

    @GetMapping("/reservas")
    public String reservas(Model model, String correo) {

        model.addAttribute("reservas", reservaRepository.darReservasPorUsuario(correo));
        return "reserva";
    }

    @GetMapping("/reservas/new")
    public String reservaForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reservaNueva";
    }

    @PostMapping("/reservas/new/save")
    public String reservaGuardar(@ModelAttribute Reserva reserva) {
        reservaRepository.insertarReserva(reserva.getCostototal(), reserva.getFechainicio(), reserva.getFechafin(),
                reserva.getPlanestadia().getId(), reserva.getHabitacion().getNumero(), reserva.getConsumo().getId(),
                reserva.getUsuario().getId(), reserva.getEstado());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/edit")
    public String reservaEditarForm(@PathVariable("id") Integer id, Model model) {
        Reserva reserva = reservaRepository.darReserva(id);
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            model.addAttribute("planesestadia", planEstadiaRepository.darPlanesEstadia());
            return "reservaEditar";
        } else {
            return "redirect:/reservas";
        }
    }

    @PostMapping("/reservas/{id}/edit/save")
    public String reservaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Reserva reserva) {
        reservaRepository.actualizarReserva(id, reserva.getCostototal(), reserva.getFechainicio(),
                reserva.getFechafin(),
                reserva.getPlanestadia().getId(), reserva.getHabitacion().getNumero(), reserva.getConsumo().getId(),
                reserva.getUsuario().getId(), reserva.getEstado());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/delete")
    public String reservaEliminar(@PathVariable("id") Integer id) {
        reservaRepository.eliminarReserva(id);
        return "redirect:/reservas";
    }

    @PostMapping("reservas/{id}/checkin")
    public String reservaCheckin(@PathVariable("id") Integer id, @ModelAttribute Reserva reserva) {
        reservaRepository.checkinReserva(id, "HOSPEDADO");
        return "redirect:/reservas";
    }

    @PostMapping("reservas/{id}/checkout")
    public String reservaCheckout(@PathVariable("id") Integer id, @ModelAttribute Reserva reserva) {
        reservaRepository.checkinReserva(id, "CHECK-OUT");
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/DineroHabitacion")
    public String dineroHabitacion(Model model) {
        List<Object[]> listaDineroHabitacion = reservaRepository.findDineroRecolectadoPorHabitacion();
        model.addAttribute("listaDineroHabitacion", listaDineroHabitacion);
        return "dineroHabitacion";
    }

}
