package com.example.apiprueba.services;

import com.example.apiprueba.models.UsuarioModel;
import com.example.apiprueba.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

// Le indicamos que sera un tipo Service y eso lo convierte en una clase de ese tipo
@Service
public class UsuarioService  {
    // Usamos autowired para poder inyectar una dependencia
    @Autowired
    UsuarioRepository usuarioRepository;

    /*
     Desarrollamos el metodo para obtener usuarios de la base de datos
     el cual sera de tipo ArrayList de UsuarioModel
    */
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        /*
         Gracias al repositorio y la extencion del CrudRepository tenemos acceso a varios metodos
         en este caso el findAll para poder traer a todos los que haya tenemos que castear
         esta data a un arreglo de tipo UsuarioModel para poder regresarlo en un JSON
        */
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    /*
     Desarrollamos el metodo que va a guardar los usuarios en la base de datos
    */
    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        // Esto nos devuelve el usuario que vamos a guardar y recibe el UsuarioModel
        return usuarioRepository.save(usuario);
    }

//    /*
//     Desarrollamos el metodo para obtener a un usuariopor el Id
//    */
//    public Optional<UsuarioModel> obtenerPorId(Long id){
//        return usuarioRepository.findById(id);
//    }
//
//    /*
//     Desarrollamos el metodo para obtener a un usuariopor el Id
//    */
//    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
//        return usuarioRepository.findBy
//    }
}
