package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Reserva;
import uniandes.edu.co.proyecto.repositories.ReservaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Transactional
    public Reserva createReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Transactional
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    @Transactional
    public Reserva getReservaById(Integer id) {
        return reservaRepository.findById(id);
    }

    @Transactional
    public Reserva updateReserva(Integer id, Reserva updatedReserva) {
        Reserva existingReserva = reservaRepository.findById(id);
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
