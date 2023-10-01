package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE cedula = :cedula", nativeQuery = true)
    Usuario darUsuario(@Param("cedula") Integer cedula);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (cedula, nombre, apellido, correo, tipoUsuario, password, numAcompaniantes, areaEmpleado) VALUES (:cedula, :nombre, :apellido, :correo, :tipoUsuario, :password, :numAcompaniantes, :areaEmpleado)", nativeQuery = true)
    void insertarUsuario(@Param("cedula") Integer cedula, @Param("nombre") String nombre, @Param("apellido") String apellido,
                        @Param("correo") String correo, @Param("tipoUsuario") String tipoUsuario, @Param("password") String password,
                        @Param("numAcompaniantes") Integer numAcompaniantes, @Param("areaEmpleado") String areaEmpleado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET nombre = :nombre, apellido = :apellido, correo = :correo, tipoUsuario = :tipoUsuario, password = :password, numAcompaniantes = :numAcompaniantes, areaEmpleado = :areaEmpleado WHERE cedula = :cedula", nativeQuery = true)
    void actualizarUsuario(@Param("cedula") Integer cedula, @Param("nombre") String nombre, @Param("apellido") String apellido,
                        @Param("correo") String correo, @Param("tipoUsuario") String tipoUsuario, @Param("password") String password,
                        @Param("numAcompaniantes") Integer numAcompaniantes, @Param("areaEmpleado") String areaEmpleado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE cedula = :cedula", nativeQuery = true)
    void eliminarUsuario(@Param("cedula") Integer cedula);
    
}