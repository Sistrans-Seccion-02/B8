package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.ServicioEntity;
import uniandes.edu.co.proyecto.repositories.ServicioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Transactional
    public ServicioEntity createServicio(ServicioEntity servicio) {
        return servicioRepository.save(servicio);
    }

    @Transactional
    public List<ServicioEntity> getAllServicios() {
        return servicioRepository.findAll();
    }

    @Transactional
    public ServicioEntity getServicioById(Long id) {
        Optional<ServicioEntity> servicioOptional = servicioRepository.findById(id);
        return servicioOptional.orElse(null);
    }

    @Transactional
    public ServicioEntity updateServicio(Long id, ServicioEntity updatedServicio) {
        Optional<ServicioEntity> existingServicioOptional = servicioRepository.findById(id);
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
