package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Supermercado;
import uniandes.edu.co.proyecto.repositories.SupermercadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupermercadoService {

    @Autowired
    private SupermercadoRepository supermercadoRepository;

    @Transactional
    public Supermercado createSupermercado(Supermercado supermercado) {
        return supermercadoRepository.save(supermercado);
    }

    @Transactional
    public List<Supermercado> getAllSupermercados() {
        return supermercadoRepository.findAll();
    }

    @Transactional
    public Supermercado getSupermercadoById(Long id) {
        Optional<Supermercado> supermercadoOptional = supermercadoRepository.findById(id);
        return supermercadoOptional.orElse(null);
    }

    @Transactional
    public Supermercado updateSupermercado(Long id, Supermercado updatedSupermercado) {
        Optional<Supermercado> existingSupermercadoOptional = supermercadoRepository.findById(id);
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
