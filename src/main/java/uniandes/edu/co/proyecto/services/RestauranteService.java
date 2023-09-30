package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Restaurante;
import uniandes.edu.co.proyecto.repositories.RestauranteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Transactional
    public Restaurante createRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Transactional
    public List<Restaurante> getAllRestaurantes() {
        return restauranteRepository.findAll();
    }

    @Transactional
    public Restaurante getRestauranteById(Long id) {
        Optional<Restaurante> restauranteOptional = restauranteRepository.findById(id);
        return restauranteOptional.orElse(null);
    }

    @Transactional
    public Restaurante updateRestaurante(Long id, Restaurante updatedRestaurante) {
        Optional<Restaurante> existingRestauranteOptional = restauranteRepository.findById(id);
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
