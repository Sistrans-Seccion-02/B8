package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Piscina;
import uniandes.edu.co.proyecto.repositories.PiscinaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PiscinaService {

    @Autowired
    private PiscinaRepository piscinaRepository;

    @Transactional
    public Piscina createPiscina(Piscina piscina) {
        return piscinaRepository.save(piscina);
    }

    @Transactional
    public List<Piscina> getAllPiscinas() {
        return piscinaRepository.findAll();
    }

    @Transactional
    public Piscina getPiscinaById(Long id) {
        Optional<Piscina> piscinaOptional = piscinaRepository.findById(id);
        return piscinaOptional.orElse(null);
    }

    @Transactional
    public Piscina updatePiscina(Long id, Piscina updatedPiscina) {
        Optional<Piscina> existingPiscinaOptional = piscinaRepository.findById(id);
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
