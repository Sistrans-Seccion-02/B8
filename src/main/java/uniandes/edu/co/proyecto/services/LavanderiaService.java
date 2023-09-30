package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Lavanderia;
import uniandes.edu.co.proyecto.repositories.LavanderiaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LavanderiaService {

    @Autowired
    private LavanderiaRepository lavanderiaRepository;

    @Transactional
    public Lavanderia createLavanderia(Lavanderia lavanderia) {
        return lavanderiaRepository.save(lavanderia);
    }

    @Transactional
    public List<Lavanderia> getAllLavanderia() {
        return lavanderiaRepository.findAll();
    }

    @Transactional
    public Lavanderia getLavanderiaById(Long id) {
        Optional<Lavanderia> lavanderiaOptional = lavanderiaRepository.findById(id);
        return lavanderiaOptional.orElse(null);
    }

    @Transactional
    public Lavanderia updateLavanderia(Long id,
            Lavanderia updatedLavanderia) {
        Optional<Lavanderia> existingLavanderiaOptional = lavanderiaRepository
                .findById(id);
        if (existingLavanderiaOptional.isPresent()) {
            updatedLavanderia.setId(id);
            return lavanderiaRepository.save(updatedLavanderia);
        } else {
            return null; // LavanderiaEmboladaEntity with the given ID not found
        }
    }

    @Transactional
    public void deleteLavanderia(Long id) {
        lavanderiaRepository.deleteById(id);
    }
}
