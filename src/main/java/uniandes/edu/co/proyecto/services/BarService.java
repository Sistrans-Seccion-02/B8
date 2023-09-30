package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Bar;
import uniandes.edu.co.proyecto.repositories.BarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BarService {

    @Autowired
    private BarRepository barRepository;

    @Transactional
    public Bar createBar(Bar bar) {
        return barRepository.save(bar);
    }

    @Transactional
    public List<Bar> getAllBars() {
        return barRepository.findAll();
    }

    @Transactional
    public Bar getBarById(Long id) {
        Optional<Bar> barOptional = barRepository.findById(id);
        return barOptional.orElse(null);
    }

    @Transactional
    public Bar updateBar(Long id, Bar updatedBar) {
        Optional<Bar> existingBarOptional = barRepository.findById(id);
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
