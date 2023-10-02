package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Gimnasio;

@Repository
public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer> {
    @Query(value = "SELECT * FROM gimnasios", nativeQuery = true)
    Collection<Gimnasio> darGimnasios();

    @Query(value = "SELECT * FROM gimnasios WHERE id = :id", nativeQuery = true)
    Gimnasio darGimnasio(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gimnasios (id, maquinas, horario) VALUES (:id, :maquinas, :horario)", nativeQuery = true)
    void insertarGimnasio(@Param("id") Integer id, @Param("maquinas") String maquinas, @Param("horario") String horario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gimnasios SET maquinas = :maquinas, horario = :horario  WHERE id = :id", nativeQuery = true)
    void actualizarGimnasio(@Param("id") Integer id, @Param("maquinas") String maquinas,  @Param("horario") String horario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gimnasios WHERE id = :id", nativeQuery = true)
    void eliminarGimnasio(@Param("id") Integer id);
    

}