package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.SpaEntity;
import uniandes.edu.co.proyecto.repositories.SpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SpaService {

    @Autowired
    private SpaRepository spaRepository;

    @Transactional
    public SpaEntity createSpa(SpaEntity spa) {
        return spaRepository.save(spa);
    }

    @Transactional
    public List<SpaEntity> getAllSpas() {
        return spaRepository.findAll();
    }

    @Transactional
    public SpaEntity getSpaById(Long id) {
        Optional<SpaEntity> spaOptional = spaRepository.findById(id);
        return spaOptional.orElse(null);
    }

    @Transactional
    public SpaEntity updateSpa(Long id, SpaEntity updatedSpa) {
        Optional<SpaEntity> existingSpaOptional = spaRepository.findById(id);
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
