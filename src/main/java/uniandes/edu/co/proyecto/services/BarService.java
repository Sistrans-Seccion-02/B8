package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.BarEntity;
import uniandes.edu.co.proyecto.repositories.BarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BarService {

    @Autowired
    private BarRepository barRepository;

    @Transactional
    public BarEntity createBar(BarEntity bar) {
        return barRepository.save(bar);
    }

    @Transactional
    public List<BarEntity> getAllBars() {
        return barRepository.findAll();
    }

    @Transactional
    public BarEntity getBarById(Long id) {
        Optional<BarEntity> barOptional = barRepository.findById(id);
        return barOptional.orElse(null);
    }

    @Transactional
    public BarEntity updateBar(Long id, BarEntity updatedBar) {
        Optional<BarEntity> existingBarOptional = barRepository.findById(id);
        if (existingBarOptional.isPresent()) {
            updatedBar.setId(id);
            return barRepository.save(updatedBar);
        } else {
            return null; // Bar with the given ID not found
        }
    }

    @Transactional
    public void deleteBar(Long id) {
        barRepository.deleteById(id);
    }
}
