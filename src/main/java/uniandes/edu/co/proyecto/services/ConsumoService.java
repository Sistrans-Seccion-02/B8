package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Consumo;
import uniandes.edu.co.proyecto.repositories.ConsumoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository consumoRepository;

    @Transactional
    public Consumo createConsumo(Consumo consumo) {
        return consumoRepository.save(consumo);
    }

    @Transactional
    public List<Consumo> getAllConsumos() {
        return consumoRepository.findAll();
    }

    @Transactional
    public Consumo getConsumoById(Long id) {
        Optional<Consumo> consumoOptional = consumoRepository.findById(id);
        return consumoOptional.orElse(null);
    }

    @Transactional
    public Consumo updateConsumo(Long id, Consumo updatedConsumo) {
        Optional<Consumo> existingConsumoOptional = consumoRepository.findById(id);
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
