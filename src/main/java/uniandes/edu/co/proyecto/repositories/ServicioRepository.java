package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    @Query(value = "SELECT * FROM servicios", nativeQuery = true)
    Collection<Servicio> darServicios();

    @Query(value = "SELECT * FROM servicios WHERE id = :id", nativeQuery = true)
    Servicio darServicio(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicios (id, capacidad, nombre, idHotel, clase) VALUES ( servicios_sequence.nextval, :capacidad, :nombre, :idHotel, :clase)", nativeQuery = true)
    void insertarServicio(@Param("capacidad") Float capacidad, @Param("nombre") String nombre, 
                            @Param("idHotel") Integer idHotel, @Param("clase") String clase);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios SET capacidad = :capacidad, nombre = :nombre, idHotel = :idHotel WHERE id = :id", nativeQuery = true)
    void actualizarServicio(@Param("id") Integer id, @Param("capacidad") Float capacidad,
                        @Param("nombre") String nombre, @Param("idHotel") Integer idHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarServicio(@Param("id") Integer id);
    
}