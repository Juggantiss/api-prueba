package com.example.apiprueba.services;

import com.example.apiprueba.models.MusicaModel;
import com.example.apiprueba.repositories.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository musicaRepository;

    public ArrayList<MusicaModel> obtenerMusicas(){
        return (ArrayList<MusicaModel>) musicaRepository.findAll();
    }

    public ResponseEntity<MusicaModel> obtenerMusicaPorId(String id){
        Optional<MusicaModel> musicaData = musicaRepository.findById(id);
        if (musicaData.isPresent()) {
            return new ResponseEntity<>(musicaData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public MusicaModel guardarMusica(MusicaModel musica){
        return musicaRepository.save(musica);
    }

    public MusicaModel actualizarMusica(MusicaModel musica){
        return musicaRepository.save(musica);
    }

    public void eliminarMusica(@PathVariable String id){
        musicaRepository.deleteById(id);
    }
}
