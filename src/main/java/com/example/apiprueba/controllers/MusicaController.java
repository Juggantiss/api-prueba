package com.example.apiprueba.controllers;

import com.example.apiprueba.models.MusicaModel;
import com.example.apiprueba.services.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/musica")
public class MusicaController {
    @Autowired
    private MusicaService musicaService;

    @GetMapping
    public ResponseEntity<List<MusicaModel>> obtenerMusicas(@RequestParam(required = false) String autor){
        return musicaService.obtenerMusicas(autor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicaModel> obtenerMusicaPorId(@PathVariable("id") String id){
        return musicaService.obtenerMusicaPorId(id);
    }

    @PostMapping
    public ResponseEntity<MusicaModel> guardarMusica(@RequestBody MusicaModel musica){
        return musicaService.guardarMusica(musica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicaModel> actualizarMusica(@PathVariable("id") String id, @Validated @RequestBody MusicaModel musica){
        musica.setId(id);
        return musicaService.actualizarMusica(musica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarMusica(@PathVariable("id") String id){
        return musicaService.eliminarMusica(id);
    }
}
