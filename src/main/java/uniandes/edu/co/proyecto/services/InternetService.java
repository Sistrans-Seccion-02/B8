package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.InternetEntity;
import uniandes.edu.co.proyecto.repositories.InternetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InternetService {

    @Autowired
    private InternetRepository internetRepository;

    @Transactional
    public InternetEntity createInternet(InternetEntity internet) {
        return internetRepository.save(internet);
    }

    @Transactional
    public List<InternetEntity> getAllInternetEntities() {
        return internetRepository.findAll();
    }

    @Transactional
    public InternetEntity getInternetById(Long id) {
        Optional<InternetEntity> internetOptional = internetRepository.findById(id);
        return internetOptional.orElse(null);
    }

    @Transactional
    public InternetEntity updateInternet(Long id, InternetEntity updatedInternet) {
        Optional<InternetEntity> existingInternetOptional = internetRepository.findById(id);
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
