package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Spa;
import uniandes.edu.co.proyecto.repositories.SpaRepository;

import org.springframework.ui.Model;

@Controller
public class SpaController {

    @Autowired
    private SpaRepository spaRepository;

    @GetMapping("/spas")
    public String spas(Model model) {
        model.addAttribute("spas", spaRepository.darSpas());
        return "spas";
    }

    @GetMapping("/spas/new")
    public String spaForm(Model model) {
        model.addAttribute("spa", new Spa());
        return "spaNuevo";
    }

    @PostMapping("/spas/new/save")
    public String spaGuardar(@ModelAttribute Spa spa) {
        spaRepository.insertarSpa(spa.getId(), spa.getCapacidad(), spa.getCostoDanios(), spa.getNombre(), spa.getCatalogo());
        return "redirect:/spas";
    }

    @GetMapping("/spas/{id}/edit")
    public String spaEditarForm(@PathVariable("id") Integer id, Model model) {
        Spa spa = spaRepository.darSpa(id);
        if (spa != null) {
            model.addAttribute("spa", spa);
            return "spaEditar";
        } else {
            return "redirect:/spas";
        }
    }

    @PostMapping("/spas/{id}/edit/save")
    public String spaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Spa spa) {
        spaRepository.actualizarSpa(id, spa.getCapacidad(), spa.getCostoDanios(), spa.getNombre(), spa.getCatalogo());
        return "redirect:/spas";
    }
    
}
