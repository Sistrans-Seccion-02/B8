package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Internet;
import uniandes.edu.co.proyecto.repositories.InternetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InternetService {

    @Autowired
    private InternetRepository internetRepository;

    @Transactional
    public Internet createInternet(Internet internet) {
        return internetRepository.save(internet);
    }

    @Transactional
    public List<Internet> getAllInternetEntities() {
        return internetRepository.findAll();
    }

    @Transactional
    public Internet getInternetById(Long id) {
        Optional<Internet> internetOptional = internetRepository.findById(id);
        return internetOptional.orElse(null);
    }

    @Transactional
    public Internet updateInternet(Long id, Internet updatedInternet) {
        Optional<Internet> existingInternetOptional = internetRepository.findById(id);
        if (existingInternetOptional.isPresent()) {
            updatedInternet.setId(id);
            return internetRepository.save(updatedInternet);
        } else {
            return null; // InternetEntity with the given ID not found
        }
    }

    @Transactional
    public void deleteInternet(Long id) {
        internetRepository.deleteById(id);
    }
}
