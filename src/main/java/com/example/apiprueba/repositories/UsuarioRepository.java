package com.example.apiprueba.repositories;

import com.example.apiprueba.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/* Indicamos que esta interface sera un repository para persistencia de datos.
   Extendemos a la clase CrudRepository que es la que contiene la mayoria de
   metodos que vamos a ocupar ( create, read, update, delete )
   y le indicamos la propiedad de que tipo sera en este caso tipo UsuarioModel
   y el tipo de id que tiene en este caso Long
*/
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
}
