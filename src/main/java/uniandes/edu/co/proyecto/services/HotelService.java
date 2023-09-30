package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Hotel;
import uniandes.edu.co.proyecto.repositories.HotelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Transactional
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Transactional
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Transactional
    public Hotel getHotelByNombre(String nombre) {
        Hotel hotelOptional = hotelRepository.findByNombre(null);
        return hotelOptional;
    }

    @Transactional
    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        Optional<Hotel> existingHotelOptional = hotelRepository.findById(id);
        if (existingHotelOptional.isPresent()) {
            updatedHotel.setId(id);
            return hotelRepository.save(updatedHotel);
        } else {
            return null; // Hotel with the given ID not found
        }
    }

    @Transactional
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}