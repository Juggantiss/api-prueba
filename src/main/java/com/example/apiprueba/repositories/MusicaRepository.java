package com.example.apiprueba.repositories;

import com.example.apiprueba.models.MusicaModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends MongoRepository<MusicaModel, String> {
//    MusicaModel buscarPorId(String id);
//    List<MusicaModel> buscarPorNombre(String nombre);
//    List<MusicaModel> buscarPorAutor(String autor);

}
