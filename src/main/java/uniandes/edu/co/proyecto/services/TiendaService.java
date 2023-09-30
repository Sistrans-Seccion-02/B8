package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.TiendaEntity;
import uniandes.edu.co.proyecto.repositories.TiendaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    @Transactional
    public TiendaEntity createTienda(TiendaEntity tienda) {
        return tiendaRepository.save(tienda);
    }

    @Transactional
    public List<TiendaEntity> getAllTiendas() {
        return tiendaRepository.findAll();
    }

    @Transactional
    public TiendaEntity getTiendaById(Long id) {
        Optional<TiendaEntity> tiendaOptional = tiendaRepository.findById(id);
        return tiendaOptional.orElse(null);
    }

    @Transactional
    public TiendaEntity updateTienda(Long id, TiendaEntity updatedTienda) {
        Optional<TiendaEntity> existingTiendaOptional = tiendaRepository.findById(id);
        if (existingTiendaOptional.isPresent()) {
            updatedTienda.setId(id);
            return tiendaRepository.save(updatedTienda);
        } else {
            return null; // TiendaEntity with the given ID not found
        }
    }

    @Transactional
    public void deleteTienda(Long id) {
        tiendaRepository.deleteById(id);
    }
}
