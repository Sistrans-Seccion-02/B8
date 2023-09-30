package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.entities.UsuarioEntity;
import uniandes.edu.co.proyecto.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioEntity createUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public List<UsuarioEntity> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public UsuarioEntity getUsuarioById(Long id) {
        Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.orElse(null);
    }

    @Transactional
    public UsuarioEntity updateUsuario(Long id, UsuarioEntity updatedUsuario) {
        Optional<UsuarioEntity> existingUsuarioOptional = usuarioRepository.findById(id);
        if (existingUsuarioOptional.isPresent()) {
            updatedUsuario.setId(id);
            return usuarioRepository.save(updatedUsuario);
        } else {
            return null; // UsuarioEntity with the given ID not found
        }
    }

    @Transactional
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
