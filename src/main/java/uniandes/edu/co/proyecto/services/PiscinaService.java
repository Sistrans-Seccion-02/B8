package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.PiscinaEntity;
import uniandes.edu.co.proyecto.repositories.PiscinaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PiscinaService {

    @Autowired
    private PiscinaRepository piscinaRepository;

    @Transactional
    public PiscinaEntity createPiscina(PiscinaEntity piscina) {
        return piscinaRepository.save(piscina);
    }

    @Transactional
    public List<PiscinaEntity> getAllPiscinas() {
        return piscinaRepository.findAll();
    }

    @Transactional
    public PiscinaEntity getPiscinaById(Long id) {
        Optional<PiscinaEntity> piscinaOptional = piscinaRepository.findById(id);
        return piscinaOptional.orElse(null);
    }

    @Transactional
    public PiscinaEntity updatePiscina(Long id, PiscinaEntity updatedPiscina) {
        Optional<PiscinaEntity> existingPiscinaOptional = piscinaRepository.findById(id);
        if (existingPiscinaOptional.isPresent()) {
            updatedPiscina.setId(id);
            return piscinaRepository.save(updatedPiscina);
        } else {
            return null; // PiscinaEntity with the given ID not found
        }
    }

    @Transactional
    public void deletePiscina(Long id) {
        piscinaRepository.deleteById(id);
    }
}
