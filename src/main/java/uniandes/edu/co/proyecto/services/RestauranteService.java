package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.RestauranteEntity;
import uniandes.edu.co.proyecto.repositories.RestauranteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Transactional
    public RestauranteEntity createRestaurante(RestauranteEntity restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Transactional
    public List<RestauranteEntity> getAllRestaurantes() {
        return restauranteRepository.findAll();
    }

    @Transactional
    public RestauranteEntity getRestauranteById(Long id) {
        Optional<RestauranteEntity> restauranteOptional = restauranteRepository.findById(id);
        return restauranteOptional.orElse(null);
    }

    @Transactional
    public RestauranteEntity updateRestaurante(Long id, RestauranteEntity updatedRestaurante) {
        Optional<RestauranteEntity> existingRestauranteOptional = restauranteRepository.findById(id);
        if (existingRestauranteOptional.isPresent()) {
            updatedRestaurante.setId(id);
            return restauranteRepository.save(updatedRestaurante);
        } else {
            return null; // RestauranteEntity with the given ID not found
        }
    }

    @Transactional
    public void deleteRestaurante(Long id) {
        restauranteRepository.deleteById(id);
    }
}
