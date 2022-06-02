package com.example.apiprueba.controllers;

import com.example.apiprueba.models.UsuarioModel;
import com.example.apiprueba.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


// Indicamos que esta clase sera una ruta de rest para consumir en la ruta /usuario
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    // Importamos el servicio con un AutoWired
    @Autowired
    UsuarioService usuarioService;

    // Le indicamos cuando llegue una peticion get del navegador para ejecutar este flujo
    @GetMapping
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        // Regresamos el arreglo de todos los usuarios, invocando el metodo del servicio obtenerUsuarios
        return usuarioService.obtenerUsuarios();
    }

    /*
     Le indicamos que sera una peticion de tipo post para ejecutar el flujo
     nuestro metodo para recibir como parametro un RequestBody, todos los clientes pueden
     enviar informacion dentro del cuerpo de la solicitud http, para tomar la informacion
     y guardarla en el objeto usuario
    */
    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
}
