package com.tutorial.SpringBoot.MongoDB.repository;
import com.tutorial.SpringBoot.MongoDB.model.Producto;// Importamos la clase Producto que definimos en el modelo
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;// Importamos la interfaz MongoRepository de Spring Data
import org.springframework.stereotype.Repository;// Importamos la anotación @Repository para indicar que esta interfaz es un repositorio

@Repository
public interface ProductoRepository extends MongoRepository<Producto, ObjectId> {

}
