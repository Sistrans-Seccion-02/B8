package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Embolada;
import uniandes.edu.co.proyecto.repositories.EmboladaRepository;


@Controller
public class EmboladaController {
    @Autowired
    private EmboladaRepository emboladaRepository;

    @GetMapping("/emboladas")
    public String emboladas(Model model) {
        model.addAttribute("emboladas", emboladaRepository.darEmboladas());
        return "emboladas";
    }

    @GetMapping("/emboladas/new")
    public String emboladaForm(Model model) {
        model.addAttribute("embolada", new Embolada());
        return "emboladaNuevo";
    }

    @PostMapping("/emboladas/new/save")
    public String emboladaGuardar(@ModelAttribute Embolada embolada) {
        emboladaRepository.insertarEmbolada(embolada.getId(), embolada.getCatalogo(), embolada.getNumeroPrendas(), embolada.getTipoPrenda());
        return "redirect:/supermercados";
    }

    @GetMapping("/emboladas/{id}/edit")
    public String emboladaEditarForm(@PathVariable("id") Integer id, Model model) {
        Embolada embolada = emboladaRepository.darEmbolada(id);
        if (embolada != null) {
            model.addAttribute("embolada", embolada);
            return "emboladaEditar";
        } else {
            return "redirect:/emboladas";
        }
    }

    @PostMapping("/emboladas/{id}/edit/save")
    public String emboladaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Embolada embolada) {
        emboladaRepository.actualizarEmbolada(id, embolada.getCatalogo(), embolada.getNumeroPrendas(), embolada.getTipoPrenda());
        return "redirect:/emboladas";
    }

    @GetMapping("/emboladas/{id}/delete")
    public String emboladaEliminar(@PathVariable("id") Integer id) {
        emboladaRepository.eliminarEmbolada(id);
        return "redirect:/emboladas";
    }

}
