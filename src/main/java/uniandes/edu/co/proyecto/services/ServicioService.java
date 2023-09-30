package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Servicio;
import uniandes.edu.co.proyecto.repositories.ServicioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Transactional
    public Servicio createServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Transactional
    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }

    @Transactional
    public Servicio getServicioById(Long id) {
        Optional<Servicio> servicioOptional = servicioRepository.findById(id);
        return servicioOptional.orElse(null);
    }

    @Transactional
    public Servicio updateServicio(Long id, Servicio updatedServicio) {
        Optional<Servicio> existingServicioOptional = servicioRepository.findById(id);
        if (existingServicioOptional.isPresent()) {
            updatedServicio.setId(id);
            return servicioRepository.save(updatedServicio);
        } else {
            return null; // ServicioEntity with the given ID not found
        }
    }

    @Transactional
    public void deleteServicio(Long id) {
        servicioRepository.deleteById(id);
    }
}
