package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.data.mongodb.repository.DeleteQuery;

import com.example.demo.modelo.Servicio;

public interface ServicioRepository extends MongoRepository<Servicio, String> {

    @Query("{}")
    List<Servicio> findAll();

    @Query("{'_id': ?0}")
    Servicio buscarPorId(String id);

    @Query("{'_id': ?0}")
    @Update("{$set: {'nombre': ?1, 'capacidad': ?2, 'costoDanios': ?3}}")
    void actualizarServicio(String id, String nombre, Integer capacidad, Double costoDanios);

    @DeleteQuery("{'_id': ?0}")
    void eliminarServicio(String id);
    
}
