package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Tiene;

import java.util.Collection;

public interface TieneRepository extends JpaRepository<Tiene, Integer>{

    @Query(value = "SELECT * FROM tiene", nativeQuery = true)
    Collection<Tiene> darTiene();

    @Query(value = "SELECT * FROM tiene WHERE idHotel = :idHotel AND idUsuario = :idUsuario", nativeQuery = true)
    Tiene darTienePorId(@Param("idHotel") Integer idHotel, @Param("idUsuario") Integer idUsuario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiene WHERE idHotel = :idHotel AND idUsuario = :idUsuario", nativeQuery = true)
    void eliminarTiene(@Param("idHotel") Integer idHotel, @Param("idUsuario") Integer idUsuario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tiene SET idHotel = :idHotel_actualizado, idUsuario = :idUsuario_actualizado WHERE idHotel = :idHotel AND idUsuario = :idUsuario", nativeQuery = true)
    void actualizarTiene(@Param("idHotel") Integer idHotel, @Param("idUsuario") Integer idUsuario, @Param("idHotel_actualizado") Integer idHotel_actualizado, @Param("idUsuario_actualizado") Integer idUsuario_actualizado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiene (idHotel, idUsuario) VALUES (:idHotel, :idUsuario)", nativeQuery = true)
    void insertarTiene(@Param("idHotel") Integer idHotel, @Param("idUsuario") Integer idUsuario);
    
}
