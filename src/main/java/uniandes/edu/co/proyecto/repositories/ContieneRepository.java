package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Contiene;

import java.util.Collection;

public interface ContieneRepository extends JpaRepository<Contiene, Integer>{

    @Query(value = "SELECT * FROM contiene", nativeQuery = true)
    Collection<Contiene> darContiene();

    @Query(value = "SELECT * FROM contiene WHERE idServicio = :idServicio AND idConsumo = :idConsumo", nativeQuery = true)
    Contiene darContienePorId(@Param("idServicio") Integer idServicio, @Param("idConsumo") Integer idConsumo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM contiene WHERE idServicio = :idServicio AND idConsumo = :idConsumo", nativeQuery = true)
    void eliminarContiene(@Param("idServicio") Integer idServicio, @Param("idConsumo") Integer idConsumo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE contiene SET idServicio = :idServicio_actualizado, idConsumo = :idConsumo_actualizado WHERE idServicio = :idServicio AND idConsumo = :idConsumo", nativeQuery = true)
    void actualizarContiene(@Param("idServicio") Integer idServicio, @Param("idConsumo") Integer idConsumo, @Param("idServicio_actualizado") Integer idServicio_actualizado, @Param("idConsumo_actualizado") Integer idConsumo_actualizado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO contiene (idServicio, idConsumo) VALUES (:idServicio, :idConsumo)", nativeQuery = true)
    void insertarContiene(@Param("idServicio") Integer idServicio, @Param("idConsumo") Integer idConsumo);
    
}
