package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Usuario;
import uniandes.edu.co.proyecto.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario getUsuarioById(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.orElse(null);
    }

    @Transactional
    public Usuario updateUsuario(Long id, Usuario updatedUsuario) {
        Optional<Usuario> existingUsuarioOptional = usuarioRepository.findById(id);
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
