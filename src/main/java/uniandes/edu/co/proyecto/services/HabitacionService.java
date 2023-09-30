package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.habitacionEntity;
import uniandes.edu.co.proyecto.repositories.HabitacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Transactional
    public habitacionEntity createHabitacion(habitacionEntity habitacion) {
        return habitacionRepository.save(habitacion);
    }

    @Transactional
    public List<habitacionEntity> getAllHabitaciones() {
        return habitacionRepository.findAll();
    }

    @Transactional
    public habitacionEntity getHabitacionByNumero(Integer numero) {
        habitacionEntity habitacion = habitacionRepository.findByNumero(numero);
        return habitacion;
    }

    @Transactional
    public habitacionEntity updateHabitacion(Long id, habitacionEntity updatedHabitacion) {
        Optional<habitacionEntity> existingHabitacionOptional = habitacionRepository.findById(id);
        if (existingHabitacionOptional.isPresent()) {
            updatedHabitacion.setId(id);
            return habitacionRepository.save(updatedHabitacion);
        } else {
            return null; // Habitacion with the given ID not found
        }
    }

    @Transactional
    public void deleteHabitacion(Long id) {
        habitacionRepository.deleteById(id);
    }
}
