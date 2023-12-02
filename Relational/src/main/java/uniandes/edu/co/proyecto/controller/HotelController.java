package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Hotel;
import uniandes.edu.co.proyecto.repositories.HotelRepository;

@Controller
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/hoteles")
    public String hoteles(Model model) {
        model.addAttribute("hoteles", hotelRepository.darHoteles());
        return "hoteles";
    }

    @GetMapping("/hoteles/new")
    public String hotelForm(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "hotelNuevo";
    }

    @PostMapping("/hoteles/new/save")
    public String hotelGuardar(@ModelAttribute Hotel hotel) {
        hotelRepository.insertarHotel(hotel.getNombre(), hotel.getDireccion(), hotel.getCiudad(), hotel.getPais());
        return "redirect:/hoteles";
    }

    @GetMapping("/hoteles/{id}/edit")
    public String hotelesEditarForm(@PathVariable("id") Integer id, Model model) {
        Hotel hotel = hotelRepository.darHotel(id);
        if (hotel != null) {
            model.addAttribute("hotel", hotel);
            return "hotelEditar";
        } else {
            return "redirect:/hoteles";
        }
    }

    @PostMapping("/hoteles/{id}/edit/save")
    public String hotelEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Hotel hotel) {
        hotelRepository.actualizarHotel(id, hotel.getNombre(), hotel.getDireccion(), hotel.getCiudad(), hotel.getPais());
        return "redirect:/hoteles";
    }

    @GetMapping("/hoteles/{id}/delete")
    public String hotelEliminar(@PathVariable("id") Integer id) {
        hotelRepository.eliminarHotel(id);
        return "redirect:/hoteles";
    }

}


