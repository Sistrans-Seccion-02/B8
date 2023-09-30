package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Habitacion;
import uniandes.edu.co.proyecto.repositories.HabitacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Transactional
    public Habitacion createHabitacion(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    @Transactional
    public List<Habitacion> getAllHabitaciones() {
        return habitacionRepository.findAll();
    }

    @Transactional
    public Habitacion getHabitacionByNumero(Integer numero) {
        Habitacion habitacion = habitacionRepository.findByNumero(numero);
        return habitacion;
    }

    @Transactional
    public Habitacion updateHabitacion(Long id, Habitacion updatedHabitacion) {
        Optional<Habitacion> existingHabitacionOptional = habitacionRepository.findById(id);
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
