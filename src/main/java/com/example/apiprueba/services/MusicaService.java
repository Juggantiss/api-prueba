package com.example.apiprueba.services;

import com.example.apiprueba.models.MusicaModel;
import com.example.apiprueba.repositories.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MusicaService {
    @Autowired
    MusicaRepository musicaRepository;

    public ArrayList<MusicaModel> obtenerMusicas(){
        return (ArrayList<MusicaModel>) musicaRepository.findAll();
    }

    public MusicaModel guardarMusica(MusicaModel musica){
        return musicaRepository.save(musica);
    }
}
