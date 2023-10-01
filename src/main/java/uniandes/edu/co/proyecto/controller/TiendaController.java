package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Tienda;
import uniandes.edu.co.proyecto.repositories.TiendaRepository;

import org.springframework.ui.Model;

@Controller
public class TiendaController {
    
    @Autowired
    private TiendaRepository tiendaRepository;

    @GetMapping("/tiendas")
    public String tiendas(Model model) {
        model.addAttribute("tiendas", tiendaRepository.darTiendas());
        return "tiendas";
    }

    @GetMapping("/tiendas/new")
    public String tiendaForm(Model model) {
        model.addAttribute("tienda", new Tienda());
        return "tiendaNuevo";
    }

    @PostMapping("/tiendas/new/save")
    public String tiendaGuardar(@ModelAttribute Tienda tienda) {
        tiendaRepository.insertarTienda(tienda.getId(), tienda.getTipo(), tienda.getProductos());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}/edit")
    public String tiendaEditarForm(@PathVariable("id") Integer id, Model model) {
        Tienda tienda = tiendaRepository.darTienda(id);
        if (tienda != null) {
            model.addAttribute("tienda", tienda);
            return "tiendaEditar";
        } else {
            return "redirect:/tiendas";
        }
    }

    @PostMapping("/tiendas/{id}/edit/save")
    public String tiendaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Tienda tienda) {
        tiendaRepository.actualizarTienda(id, tienda.getTipo(), tienda.getProductos());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}/delete")
    public String tiendaEliminar(@PathVariable("id") Integer id) {
        tiendaRepository.eliminarTienda(id);
        return "redirect:/tiendas";
    }

}
