package com.example.apiprueba.repositories;

import com.example.apiprueba.models.MusicaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends CrudRepository<MusicaModel, Long> {
}
