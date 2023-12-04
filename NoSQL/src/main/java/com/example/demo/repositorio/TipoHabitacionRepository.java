package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.data.mongodb.repository.DeleteQuery;

import com.example.demo.modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends MongoRepository<TipoHabitacion, String> {

    @Query("{}")
    List<TipoHabitacion> findAll();

    @Query("{'_id': ?0}")
    TipoHabitacion buscarPorId(String id);

    @Query("{'_id': ?0}")
    @Update("{ $set: { 'nombre': ?1 } }")
    void actualizarTipoHabitacion(String id, String nombre);

    @DeleteQuery("{'_id': ?0}")
    void eliminarTipoHabitacion(String id);
    
}
