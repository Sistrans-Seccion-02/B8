package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.SupermercadoEntity;
import uniandes.edu.co.proyecto.repositories.SupermercadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupermercadoService {

    @Autowired
    private SupermercadoRepository supermercadoRepository;

    @Transactional
    public SupermercadoEntity createSupermercado(SupermercadoEntity supermercado) {
        return supermercadoRepository.save(supermercado);
    }

    @Transactional
    public List<SupermercadoEntity> getAllSupermercados() {
        return supermercadoRepository.findAll();
    }

    @Transactional
    public SupermercadoEntity getSupermercadoById(Long id) {
        Optional<SupermercadoEntity> supermercadoOptional = supermercadoRepository.findById(id);
        return supermercadoOptional.orElse(null);
    }

    @Transactional
    public SupermercadoEntity updateSupermercado(Long id, SupermercadoEntity updatedSupermercado) {
        Optional<SupermercadoEntity> existingSupermercadoOptional = supermercadoRepository.findById(id);
        if (existingSupermercadoOptional.isPresent()) {
            updatedSupermercado.setId(id);
            return supermercadoRepository.save(updatedSupermercado);
        } else {
            return null; // SupermercadoEntity with the given ID not found
        }
    }

    @Transactional
    public void deleteSupermercado(Long id) {
        supermercadoRepository.deleteById(id);
    }
}
