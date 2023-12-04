package com.example.demo.repositorio;

import java.util.List;
import java.util.Date;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.data.mongodb.repository.DeleteQuery;

import com.example.demo.modelo.*;

public interface ConsumoRepository extends MongoRepository<Consumo, String> {
            
        @Query("{}")
        List<Consumo> findAll();
    
        @Query("{'_id': ?0}")
        Consumo buscarPorId(String id);
    
        @Query("{'_id': ?0}")
        @Update("{$set: {'costo': ?1, 'fecha': ?2, 'valorTotal': ?3, 'servicio': db.servicios.find({id: ?4})}}")
        void actualizarConsumo(String id, Date fecha, Double valorTotal, String servicio);
    
        @DeleteQuery("{'_id': ?0}")
        void eliminarConsumo(String id);

}
