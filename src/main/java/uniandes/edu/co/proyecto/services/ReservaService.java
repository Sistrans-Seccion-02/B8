package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.ReservaEntity;
import uniandes.edu.co.proyecto.repositories.ReservaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Transactional
    public ReservaEntity createReserva(ReservaEntity reserva) {
        return reservaRepository.save(reserva);
    }

    @Transactional
    public List<ReservaEntity> getAllReservas() {
        return reservaRepository.findAll();
    }

    @Transactional
    public ReservaEntity getReservaById(Integer id) {
        return reservaRepository.findById(id);
    }

    @Transactional
    public ReservaEntity updateReserva(Integer id, ReservaEntity updatedReserva) {
        ReservaEntity existingReserva = reservaRepository.findById(id);
        if (existingReserva != null) {
            updatedReserva.setId(id);
            return reservaRepository.save(updatedReserva);
        } else {
            return null; // ReservaEntity with the given ID not found
        }
    }

    @Transactional
    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
