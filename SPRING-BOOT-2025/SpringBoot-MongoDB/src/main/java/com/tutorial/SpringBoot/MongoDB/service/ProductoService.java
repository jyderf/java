package com.tutorial.SpringBoot.MongoDB.service;

import com.tutorial.SpringBoot.MongoDB.model.Producto;
import com.tutorial.SpringBoot.MongoDB.repository.ProductoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private  ProductoRepository productoRepository;

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    // ⚠️ CAMBIO: findById devuelve Optional, no directamente Producto
    public Producto get(ObjectId id){
        return productoRepository.findById(id).orElse(null);
    }

    public Producto update(ObjectId id, Producto producto){
        // ⚠️ CAMBIO: también aquí, antes devolvía directamente Producto
        Producto productoActual = productoRepository.findById(id).orElse(null);
        if(productoActual != null){
            productoActual.setProducto(producto.getProducto());
            productoActual.setCosto(producto.getCosto());
            productoActual.setPrecio(producto.getPrecio());
            productoActual.setIdcategoria(producto.getIdcategoria());

            return productoRepository.save(productoActual);
        }
        return null; // si no existe, devolvemos null
    }

    public void delete(ObjectId id){
        productoRepository.deleteById(id);
    }
}
