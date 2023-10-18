package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.proyecto.model.PlanEstadia;
import uniandes.edu.co.proyecto.repositories.PlanEstadiaRepository;

import org.springframework.ui.Model;

@Controller
public class PlanEstadiaController {

    @Autowired
    private PlanEstadiaRepository planEstadiaRepository;

    @RequestMapping("/PlanesConsumo")
    public String menuPrincipal() {
        return "";
    }

    @GetMapping("/planesEstadia")
    public String planesEstadia(Model model) {
        model.addAttribute("planesEstadia", planEstadiaRepository.darPlanesEstadia());
        return "planesEstadia";
    }

    @GetMapping("/planesEstadia/new")
    public String planEstadiaForm(Model model) {
        model.addAttribute("planEstadia", new PlanEstadia());
        return "planEstadiaNuevo";
    }

    @PostMapping("/planesEstadia/new/save")
    public String planEstadiaGuardar(@ModelAttribute PlanEstadia planEstadia) {
        planEstadiaRepository.insertarPlanEstadia(planEstadia.getPlanEstadia());
        return "redirect:/planesEstadia";
    }

    @GetMapping("/planesEstadia/{id}/edit")
    public String planEstadiaEditarForm(@PathVariable("id") Integer id, Model model) {
        PlanEstadia planEstadia = planEstadiaRepository.darPlanEstadia(id);
        if (planEstadia != null) {
            model.addAttribute("planEstadia", planEstadia);
            return "planEstadiaEditar";
        } else {
            return "redirect:/planesEstadia";
        }
    }

    @PostMapping("/planesEstadia/{id}/edit/save")
    public String planEstadiaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute PlanEstadia planEstadia) {
        planEstadiaRepository.actualizarPlanEstadia(id, planEstadia.getPlanEstadia());
        return "redirect:/planesEstadia";
    }

    @GetMapping("/planesEstadia/{id}/delete")
    public String planEstadiaEliminar(@PathVariable("id") Integer id) {
        planEstadiaRepository.eliminarPlanEstadia(id);
        return "redirect:/planesEstadia";
    }

}
