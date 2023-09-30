package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCedula(Integer cedula);
    // You can add custom query methods here if needed
}