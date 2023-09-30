package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.HotelEntity;
import uniandes.edu.co.proyecto.repositories.HotelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Transactional
    public HotelEntity createHotel(HotelEntity hotel) {
        return hotelRepository.save(hotel);
    }

    @Transactional
    public List<HotelEntity> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Transactional
    public HotelEntity getHotelByNombre(String nombre) {
        HotelEntity hotelOptional = hotelRepository.findByNombre(null);
        return hotelOptional;
    }

    @Transactional
    public HotelEntity updateHotel(Long id, HotelEntity updatedHotel) {
        Optional<HotelEntity> existingHotelOptional = hotelRepository.findById(id);
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