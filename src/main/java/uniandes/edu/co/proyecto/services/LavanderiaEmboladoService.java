package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.LavanderiaEmboladaEntity;
import uniandes.edu.co.proyecto.repositories.LavanderiaEmboladaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LavanderiaEmboladoService {

    @Autowired
    private LavanderiaEmboladaRepository lavanderiaEmboladaRepository;

    @Transactional
    public LavanderiaEmboladaEntity createLavanderiaEmbolada(LavanderiaEmboladaEntity lavanderiaEmbolada) {
        return lavanderiaEmboladaRepository.save(lavanderiaEmbolada);
    }

    @Transactional
    public List<LavanderiaEmboladaEntity> getAllLavanderiaEmboladas() {
        return lavanderiaEmboladaRepository.findAll();
    }

    @Transactional
    public LavanderiaEmboladaEntity getLavanderiaEmboladaById(Long id) {
        Optional<LavanderiaEmboladaEntity> lavanderiaEmboladaOptional = lavanderiaEmboladaRepository.findById(id);
        return lavanderiaEmboladaOptional.orElse(null);
    }

    @Transactional
    public LavanderiaEmboladaEntity updateLavanderiaEmbolada(Long id,
            LavanderiaEmboladaEntity updatedLavanderiaEmbolada) {
        Optional<LavanderiaEmboladaEntity> existingLavanderiaEmboladaOptional = lavanderiaEmboladaRepository
                .findById(id);
        if (existingLavanderiaEmboladaOptional.isPresent()) {
            updatedLavanderiaEmbolada.setId(id);
            return lavanderiaEmboladaRepository.save(updatedLavanderiaEmbolada);
        } else {
            return null; // LavanderiaEmboladaEntity with the given ID not found
        }
    }

    @Transactional
    public void deleteLavanderiaEmbolada(Long id) {
        lavanderiaEmboladaRepository.deleteById(id);
    }
}
