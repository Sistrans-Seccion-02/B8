package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Internet;
import uniandes.edu.co.proyecto.repositories.InternetRepository;


@Controller
public class InternetController {

    @Autowired
    private InternetRepository internetRepository;

    @GetMapping("/planesInternet")
    public String planesInternet(Model model) {
        model.addAttribute("planesInternet", internetRepository.darPlanesInternet());
        return "planesInternet";
    }

    @GetMapping("/planesInternet/new")
    public String planInternetForm(Model model) {
        model.addAttribute("planInternet", new Internet());
        return "planesInternet";
    }

    @PostMapping("/planesInternet/new/save")
    public String planInternetGuardar(@ModelAttribute Internet internet) {
        internetRepository.insertarPlanInternet(internet.getId(), internet.getCobroPorDia());
        return "redirect:/planesInternet";
    }

    @GetMapping("/planesInternet/{id}/edit")
    public String planInternetEditarForm(@PathVariable("id") Integer id, Model model) {
        Internet internet = internetRepository.darPlanInternet(id);
        if (internet != null) {
            model.addAttribute("planInternet", internet);
            return "planInternetEditar";
        } else {
            return "redirect:/planesInternet";
        }
    }

    @PostMapping("/planesInternet/{id}/edit/save")
    public String planInternetEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Internet internet) {
        internetRepository.actualizarPlanInternet(id, internet.getCobroPorDia());
        return "redirect:/planesInternet";
    }

    @GetMapping("/planesInternet/{id}/delete")
    public String planInternetEliminar(@PathVariable("id") Integer id) {
        internetRepository.eliminarPlanInternet(id);
        return "redirect:/planesInternet";
    }

}

