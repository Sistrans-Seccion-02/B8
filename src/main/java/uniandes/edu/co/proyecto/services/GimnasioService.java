package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.GimnasioEntity;
import uniandes.edu.co.proyecto.repositories.GimnasioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GimnasioService {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @Transactional
    public GimnasioEntity createGimnasio(GimnasioEntity gimnasio) {
        return gimnasioRepository.save(gimnasio);
    }

    @Transactional
    public List<GimnasioEntity> getAllGimnasios() {
        return gimnasioRepository.findAll();
    }

    @Transactional
    public GimnasioEntity getGimnasioById(Long id) {
        Optional<GimnasioEntity> gimnasioOptional = gimnasioRepository.findById(id);
        return gimnasioOptional.orElse(null);
    }

    @Transactional
    public GimnasioEntity updateGimnasio(Long id, GimnasioEntity updatedGimnasio) {
        Optional<GimnasioEntity> existingGimnasioOptional = gimnasioRepository.findById(id);
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
