package com.tutorial.SpringBoot.MongoDB.controller;

import com.tutorial.SpringBoot.MongoDB.model.Producto;
import com.tutorial.SpringBoot.MongoDB.repository.ProductoRepository;
import com.tutorial.SpringBoot.MongoDB.service.ProductoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
        return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getProductos() {
        return new ResponseEntity<>(productoService.getProductos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable String id) {
        try {
            ObjectId objectId = new ObjectId(id); // Convierte String a ObjectId
            return productoRepository.findById(objectId)
                    .map(ResponseEntity::ok)           // Si existe, devuelve 200 con el producto
                    .orElse(ResponseEntity.notFound().build()); // Si no existe, 404
        } catch (IllegalArgumentException e) {
            // Si el id no es un ObjectId válido, devuelve 400 Bad Request
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable String id, @RequestBody Producto producto) {
        try {
            ObjectId objectId = new ObjectId(id);
            Producto updatedProducto = productoService.update(objectId, producto);
            return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            productoService.delete(objectId);
            return new ResponseEntity<>("Producto eliminado", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
