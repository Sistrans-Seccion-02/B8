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

    @Query(value = "SELECT * FROM usuarios WHERE id = :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (id, cedula, nombre, apellido, correo, tipousuario, password, numacompaniantes, areaempleado) VALUES (hotelandes_sequence.nextval, :cedula, :nombre, :apellido, :correo, :tipousuario, :password, :numacompaniantes, :areaempleado)", nativeQuery = true)
    void insertarUsuario(@Param("cedula") Integer cedula, @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("correo") String correo, @Param("tipousuario") Integer tipoUsuario,
            @Param("password") String password,
            @Param("numacompaniantes") Integer numAcompaniantes,
            @Param("areaempleado") String areaEmpleado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET cedula = :cedula, nombre = :nombre, apellido = :apellido, correo = :correo, tipousuario = :tipousuario, password = :password, numacompaniantes = :numacompaniantes, areaempleado = :areaempleado WHERE id = :id", nativeQuery = true)
    void actualizarUsuario(@Param("id") long id, @Param("cedula") Integer cedula, @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("correo") String correo, @Param("tipousuario") Integer tipoUsuario,
            @Param("password") String password,
            @Param("numacompaniantes") Integer numAcompaniantes,
            @Param("areaempleado") String areaEmpleado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") long id);
    
    @Query(value = "SELECT * FROM usuarios \r\n" + //
    "WHERE id = (SELECT id FROM tiposUsuario WHERE nombre = :rol)", nativeQuery = true)
    void consultarUsuariosPorRol(@Param("rol") String rol);

    @Query(value = "SELECT * FROM usuarios WHERE correo = :correo", nativeQuery = true)
    Usuario darUsuarioPorCorreo(@Param("correo") String correo);

}
