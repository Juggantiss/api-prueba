package com.example.apiprueba.repositories;

import com.example.apiprueba.models.MusicaModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends MongoRepository<MusicaModel, String> {
}
