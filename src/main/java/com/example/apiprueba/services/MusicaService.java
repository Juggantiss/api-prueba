package com.example.apiprueba.services;

import com.example.apiprueba.models.MusicaModel;
import com.example.apiprueba.repositories.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository musicaRepository;

    public ResponseEntity<List<MusicaModel>> obtenerMusicas(String autor){
        try {
            List<MusicaModel> musicas = new ArrayList<MusicaModel>();
            if (autor == null) {
                musicaRepository.findAll().forEach(musicas::add);
            } else{
                musicaRepository.findByAutorContaining(autor).forEach(musicas::add);
            }
            if (musicas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(musicas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<MusicaModel> obtenerMusicaPorId(String id){
        Optional<MusicaModel> musicaData = musicaRepository.findById(id);
        if (musicaData.isPresent()) {
            return new ResponseEntity<>(musicaData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<MusicaModel> guardarMusica(MusicaModel musica){
        try{
            MusicaModel _musica = musicaRepository.save(new MusicaModel(musica.getNombre(),
                    musica.getGenero(), musica.getAutor(), musica.getDuracion()));
            return new ResponseEntity<>(_musica, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<MusicaModel> actualizarMusica(MusicaModel musica){
        Optional<MusicaModel> musicaData = musicaRepository.findById(musica.getId());
        if (musicaData.isPresent()){
            MusicaModel _musica = musicaData.get();
            _musica.setNombre(musica.getNombre());
            _musica.setGenero(musica.getGenero());
            _musica.setAutor(musica.getAutor());
            _musica.setDuracion(musica.getDuracion());
            return new ResponseEntity<>(musicaRepository.save(_musica), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> eliminarMusica(String id){
        try {
            Optional<MusicaModel> musicaData = musicaRepository.findById(id);
            if (musicaData.isPresent()){
                musicaRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
