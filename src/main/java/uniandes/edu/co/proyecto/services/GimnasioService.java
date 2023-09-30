package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Gimnasio;
import uniandes.edu.co.proyecto.repositories.GimnasioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GimnasioService {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @Transactional
    public Gimnasio createGimnasio(Gimnasio gimnasio) {
        return gimnasioRepository.save(gimnasio);
    }

    @Transactional
    public List<Gimnasio> getAllGimnasios() {
        return gimnasioRepository.findAll();
    }

    @Transactional
    public Gimnasio getGimnasioById(Long id) {
        Optional<Gimnasio> gimnasioOptional = gimnasioRepository.findById(id);
        return gimnasioOptional.orElse(null);
    }

    @Transactional
    public Gimnasio updateGimnasio(Long id, Gimnasio updatedGimnasio) {
        Optional<Gimnasio> existingGimnasioOptional = gimnasioRepository.findById(id);
        if (existingGimnasioOptional.isPresent()) {
            updatedGimnasio.setId(id);
            return gimnasioRepository.save(updatedGimnasio);
        } else {
            return null; // Gimnasio with the given ID not found
        }
    }

    @Transactional
    public void deleteGimnasio(Long id) {
        gimnasioRepository.deleteById(id);
    }
}
