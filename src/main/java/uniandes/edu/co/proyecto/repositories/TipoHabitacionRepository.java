package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer>{

    @Query(value = "SELECT * FROM tiposHabitacion", nativeQuery = true)
    Collection<TipoHabitacion> darTiposHabitacion();

    @Query(value = "SELECT * FROM tiposHabitacion WHERE id = :id", nativeQuery = true)
    TipoHabitacion darTipoHabitacion(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiposHabitacion (id, nombre) VALUES ( hotelandes_sequence.nextval, :nombre)", nativeQuery = true)
    void insertarTipoHabitacion(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tiposHabitacion SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarTipoHabitacion(@Param("id") long id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiposHabitacion WHERE id = :id", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("id") long id);
    
}
