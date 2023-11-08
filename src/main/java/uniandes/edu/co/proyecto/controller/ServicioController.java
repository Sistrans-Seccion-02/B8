package uniandes.edu.co.proyecto.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        servicioRepository.actualizarServicio(id, servicio.getCapacidad(), servicio.getNombre(),
                servicio.getHotel().getId());
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/delete")
    public String servicioEliminar(@PathVariable("id") Integer id) {
        servicioRepository.eliminarServicio(id);
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/top20")
    public String mostrarFormularioTopServicios() {
        return "formularioTopServicios"; // nombre del archivo HTML para el formulario
    }

    // Procesar las fechas y mostrar los resultados
    @PostMapping("/servicios/top20")
    public String mostrarTopServicios(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            Model model) {

        List<Object[]> topServicios = servicioRepository.findTopServiciosBetweenDates(
                Date.valueOf(fechaInicio),
                Date.valueOf(fechaFin));
        model.addAttribute("topServicios", topServicios);
        return "vistaTopServicios"; // nombre del archivo HTML para mostrar los resultados
    }

    @GetMapping("/servicios/caracteristica")
    public String mostrarFormularioBusquedaServicios() {
        return "formularioBusquedaServicios"; // nombre del archivo HTML para el formulario
    }

    // Procesar los parámetros y mostrar los resultados
    @PostMapping("/servicios/caracteristica")
    public String mostrarServiciosPorCriterio(
            @RequestParam("rangopiso") BigDecimal rangopiso,
            @RequestParam("rangotecho") BigDecimal rangotecho,
            @RequestParam("fechainicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechainicio,
            @RequestParam("fechafin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechafin,
            @RequestParam("clase") String clase,
            @RequestParam("nombre") String nombre,
            Model model) {

        List<Servicio> servicios = servicioRepository.findServiciosByCriteria(
                rangopiso,
                rangotecho,
                Date.valueOf(fechainicio),
                Date.valueOf(fechafin),
                clase,
                nombre);
        model.addAttribute("servicios", servicios);
        return "vistaServiciosPorCriterio"; // nombre del archivo HTML para mostrar los resultados
    }

}
