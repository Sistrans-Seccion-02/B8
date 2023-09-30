package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.consumoEntity;
import uniandes.edu.co.proyecto.repositories.ConsumoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository consumoRepository;

    @Transactional
    public consumoEntity createConsumo(consumoEntity consumo) {
        return consumoRepository.save(consumo);
    }

    @Transactional
    public List<consumoEntity> getAllConsumos() {
        return consumoRepository.findAll();
    }

    @Transactional
    public consumoEntity getConsumoById(Long id) {
        Optional<consumoEntity> consumoOptional = consumoRepository.findById(id);
        return consumoOptional.orElse(null);
    }

    @Transactional
    public consumoEntity updateConsumo(Long id, consumoEntity updatedConsumo) {
        Optional<consumoEntity> existingConsumoOptional = consumoRepository.findById(id);
        if (existingConsumoOptional.isPresent()) {
            updatedConsumo.setId(id);
            return consumoRepository.save(updatedConsumo);
        } else {
            return null; // Consumo with the given ID not found
        }
    }

    @Transactional
    public void deleteConsumo(Long id) {
        consumoRepository.deleteById(id);
    }
}
