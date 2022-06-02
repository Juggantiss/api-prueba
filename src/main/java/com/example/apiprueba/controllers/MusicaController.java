package com.example.apiprueba.controllers;

import com.example.apiprueba.models.MusicaModel;
import com.example.apiprueba.services.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/musica")
public class MusicaController {
    @Autowired
    MusicaService musicaService;

    @GetMapping
    public ArrayList<MusicaModel> obtenerMusicas(){
        return musicaService.obtenerMusicas();
    }

    @PostMapping
    public MusicaModel guardarMusica(@RequestBody MusicaModel musica){
        return this.musicaService.guardarMusica(musica);
    }
}
