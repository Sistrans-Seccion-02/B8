package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Salon;
import uniandes.edu.co.proyecto.repositories.SalonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SalonService {

    @Autowired
    private SalonRepository salonRepository;

    @Transactional
    public Salon createSalon(Salon salon) {
        return salonRepository.save(salon);
    }

    @Transactional
    public List<Salon> getAllSalones() {
        return salonRepository.findAll();
    }

    @Transactional
    public Salon getSalonById(Long id) {
        Optional<Salon> salonOptional = salonRepository.findById(id);
        return salonOptional.orElse(null);
    }

    @Transactional
    public Salon updateSalon(Long id, Salon updatedSalon) {
        Optional<Salon> existingSalonOptional = salonRepository.findById(id);
        if (existingSalonOptional.isPresent()) {
            updatedSalon.setId(id);
            return salonRepository.save(updatedSalon);
        } else {
            return null; // SalonEntity with the given ID not found
        }
    }

    @Transactional
    public void deleteSalon(Long id) {
        salonRepository.deleteById(id);
    }
}
