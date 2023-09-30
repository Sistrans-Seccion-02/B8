package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Spa;
import uniandes.edu.co.proyecto.repositories.SpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SpaService {

    @Autowired
    private SpaRepository spaRepository;

    @Transactional
    public Spa createSpa(Spa spa) {
        return spaRepository.save(spa);
    }

    @Transactional
    public List<Spa> getAllSpas() {
        return spaRepository.findAll();
    }

    @Transactional
    public Spa getSpaById(Long id) {
        Optional<Spa> spaOptional = spaRepository.findById(id);
        return spaOptional.orElse(null);
    }

    @Transactional
    public Spa updateSpa(Long id, Spa updatedSpa) {
        Optional<Spa> existingSpaOptional = spaRepository.findById(id);
        if (existingSpaOptional.isPresent()) {
            updatedSpa.setId(id);
            return spaRepository.save(updatedSpa);
        } else {
            return null; // SpaEntity with the given ID not found
        }
    }

    @Transactional
    public void deleteSpa(Long id) {
        spaRepository.deleteById(id);
    }
}
