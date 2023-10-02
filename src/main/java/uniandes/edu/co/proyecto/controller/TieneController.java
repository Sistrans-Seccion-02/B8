package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.model.Hotel;
import uniandes.edu.co.proyecto.model.Usuario;
import uniandes.edu.co.proyecto.model.Tiene;
import uniandes.edu.co.proyecto.model.TienePK;
import uniandes.edu.co.proyecto.repositories.HotelRepository;
import uniandes.edu.co.proyecto.repositories.UsuarioRepository;
import uniandes.edu.co.proyecto.repositories.TieneRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller 
public class TieneController {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TieneRepository tieneRepository;

    @GetMapping("/tiene/new")
    public String tieneForm(Model model) {
        model.addAttribute("hoteles", hotelRepository.darHoteles());
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "tieneNuevo";
    }

    @PostMapping("/tiene/new/save")
    public String tieneGuardar(@ModelAttribute("id_hotel") Integer idHotel,
            @ModelAttribute("id_usuario") Integer idUsuario) {

        Hotel hotel = hotelRepository.darHotel(idHotel);
        Usuario usuario = usuarioRepository.darUsuario(idUsuario);
        TienePK pk = new TienePK(hotel, usuario);
        Tiene tiene = new Tiene();
        tiene.setPk(pk);
        tieneRepository.insertarTiene(tiene.getPk().getIdHotel().getId(), tiene.getPk().getIdUsuario().getId());
        return "redirect:/hoteles";
    }
    
}
