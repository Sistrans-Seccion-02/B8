package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="hoteles")

public class HotelEntity {
    private String nombre;
    private String direccion;
    private String ciudad;
    private String pais;
    public HotelEntity(String nombre, String direccion, String ciudad, String pais)
    {
        this.nombre=nombre;
        this.direccion=direccion;
        this.ciudad=ciudad;
        this.pais=pais;
    }
    public HotelEntity()
    {;}
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
