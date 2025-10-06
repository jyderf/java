package com.tutorial.SpringBoot.MongoDB.model;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;// ✅ Importación correcta de @Document de Spring Data MongoDB

@Document(collection = "productos")
public class Producto {
    @Id
    private String id;

    private String producto;
    private int costo;
    private int precio;
    private String idcategoria;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(String idcategoria) {
        this.idcategoria = idcategoria;
    }
}

