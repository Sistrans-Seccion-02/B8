package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.SalonEntity;
import uniandes.edu.co.proyecto.repositories.SalonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SalonService {

    @Autowired
    private SalonRepository salonRepository;

    @Transactional
    public SalonEntity createSalon(SalonEntity salon) {
        return salonRepository.save(salon);
    }

    @Transactional
    public List<SalonEntity> getAllSalones() {
        return salonRepository.findAll();
    }

    @Transactional
    public SalonEntity getSalonById(Long id) {
        Optional<SalonEntity> salonOptional = salonRepository.findById(id);
        return salonOptional.orElse(null);
    }

    @Transactional
    public SalonEntity updateSalon(Long id, SalonEntity updatedSalon) {
        Optional<SalonEntity> existingSalonOptional = salonRepository.findById(id);
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
