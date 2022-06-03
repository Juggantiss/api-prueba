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

    public ResponseEntity<List<MusicaModel>> obtenerMusicas(String nombre){
        try {
            List<MusicaModel> musicas = new ArrayList<MusicaModel>();
            if (nombre == null) {
                musicaRepository.findAll().forEach(musicas::add);
            } else{
                musicaRepository.findByNombreContaining(nombre).forEach(musicas::add);
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

    public MusicaModel actualizarMusica(MusicaModel musica){
        return musicaRepository.save(musica);
    }

    public void eliminarMusica(@PathVariable String id){
        musicaRepository.deleteById(id);
    }
}
