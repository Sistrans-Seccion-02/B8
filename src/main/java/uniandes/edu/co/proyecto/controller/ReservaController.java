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
    public String reservas(Model model, Integer cedula) {

        model.addAttribute("reservas", reservaRepository.darReservasPorUsuario(cedula));
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

    @GetMapping("reservas/{id}/checkin")
    public String reservaCheckin(@PathVariable("id") Integer id, Model model) {
        Reserva reserva = reservaRepository.darReserva(id);
        if (reserva != null) {
            if (reserva.getEstado().equals("CREADA")) {
                reservaRepository.checkinReserva(id);
                return "redirect:/reservas?cedula=" + reserva.getUsuario().getCedula() + "";
            } else {
                model.addAttribute("error", "No fue posible hacer el check-in del cliente");
                return "redirect:/reservas?cedula=" + reserva.getUsuario().getCedula() + "";
            }
        } else {
            model.addAttribute("error", "No se encontraron reservas para esa cédula");
            return "redirect:/reservas";
        }
    }

    @GetMapping("reservas/{id}/checkout")
    public String reservaCheckout(@PathVariable("id") Integer id, Model model) {
        Reserva reserva = reservaRepository.darReserva(id);
        if (reserva != null) {
            if (reserva.getEstado().equals("HOSPEDADO")) {
                reservaRepository.checkoutReserva(id);
                return "redirect:/reservas?cedula=" + reserva.getUsuario().getCedula() + "";
            } else {
                model.addAttribute("error", "No fue posible hacer el check-out del cliente");
                return "redirect:/reservas?cedula=" + reserva.getUsuario().getCedula() + "";
            }
        } else {
            model.addAttribute("error", "No se encontraron reservas para esa cédula");
            return "redirect:/reservas";
        }
    }

    @GetMapping("/reservas/DineroHabitacion")
    public String dineroHabitacion(Model model) {
        List<Object[]> listaDineroHabitacion = reservaRepository.findDineroRecolectadoPorHabitacion();
        model.addAttribute("listaDineroHabitacion", listaDineroHabitacion);
        return "dineroHabitacion";
    }

    @GetMapping("/reservas/indice")
    public String indiceHabitacion(Model model) {
        List<Object[]> listaindiceHabitacion = reservaRepository.findOcupacionPorHabitacion();
        model.addAttribute("listaIndiceHabitacion", listaindiceHabitacion);
        return "indiceHabitacion";
    }

    @GetMapping("/reservas/operacion")
    public String hotelOperation(Model model) {
        // Llamada a los métodos del repositorio
        List<Object[]> leastDemandedDay = reservaRepository.findLeastDemandedDay();
        List<Object[]> topIngresoDia = reservaRepository.findTopIngresoDia();
        List<Object[]> topOccupiedDate = reservaRepository.findTopOccupiedDate();

        // Agregar los resultados al modelo
        model.addAttribute("leastDemandedDay", leastDemandedDay);
        model.addAttribute("topIngresoDia", topIngresoDia);
        model.addAttribute("topOccupiedDate", topOccupiedDate);

        // Retornar la plantilla HTML
        return "hotel-operation";
    }
}
