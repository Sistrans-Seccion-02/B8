package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.modelo.*;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    @Query("{}")
    List<Usuario> findAll();

    @Query("{'_id': ?0}")
    Usuario buscarPorId(String id);
    
}
