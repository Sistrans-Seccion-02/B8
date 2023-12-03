package com.example.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "consumos_reservas")
public class ConsumoReservas {

    @Id
    private String id;

    // Numero de la reserva
    private Integer numero;

    // Lista de consumos embebidos en el documento principal
    private List<ConsumoEmbedded> Consumos;

    public ConsumoReservas(){
        //Constructor vacio para el uso de Spring
    }

    public ConsumoReservas(Integer numero, List<ConsumoEmbedded> consumos) {
        
        //Constructor con atributos. Note que si no se define una id, mongo genera una automaticamente 
        this.numero = numero;
        this.Consumos = consumos;
    }
    
    //<---------- Getters and Setters ---------->
    public Integer getNumero(){
        return numero;
    }

    public void setNumero(Integer numero){
        this.numero = numero;
    }   

    public List<ConsumoEmbedded> getConsumos(){
        return Consumos;
    }

    public void setConsumos(List<ConsumoEmbedded> consumos){
        this.Consumos = consumos;
    }

    public void addConsumo(ConsumoEmbedded consumo){
        this.Consumos.add(consumo);
    }
    
}
