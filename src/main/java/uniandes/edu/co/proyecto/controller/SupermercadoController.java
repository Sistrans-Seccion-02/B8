package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Supermercado;
import uniandes.edu.co.proyecto.repositories.SupermercadoRepository;

import org.springframework.ui.Model;

@Controller
public class SupermercadoController {
    
    @Autowired
    private SupermercadoRepository supermercadoRepository;

    @GetMapping("/supermercados")
    public String supermercados(Model model) {
        model.addAttribute("supermercados", supermercadoRepository.darSupermercados());
        return "supermercados";
    }

    @GetMapping("/supermercados/new")
    public String supermercadoForm(Model model) {
        model.addAttribute("supermercado", new Supermercado());
        return "supermercadoNuevo";
    }

    @PostMapping("/supermercados/new/save")
    public String supermercadoGuardar(@ModelAttribute Supermercado supermercado) {
        supermercadoRepository.insertarSupermercado(supermercado.getId(), supermercado.getProductos());
        return "redirect:/supermercados";
    }

    @GetMapping("/supermercados/{id}/edit")
    public String supermercadoEditarForm(@PathVariable("id") Integer id, Model model) {
        Supermercado supermercado = supermercadoRepository.darSupermercado(id);
        if (supermercado != null) {
            model.addAttribute("supermercado", supermercado);
            return "supermercadoEditar";
        } else {
            return "redirect:/supermercados";
        }
    }

    @PostMapping("/supermercados/{id}/edit/save")
    public String supermercadoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Supermercado supermercado) {
        supermercadoRepository.actualizarSupermercado(id, supermercado.getProductos());
        return "redirect:/supermercados";
    }

    @GetMapping("/supermercados/{id}/delete")
    public String supermercadoEliminar(@PathVariable("id") Integer id) {
        supermercadoRepository.eliminarSupermercado(id);
        return "redirect:/supermercados";
    }

}
