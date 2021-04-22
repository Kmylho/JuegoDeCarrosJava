package com.Kmylho.JuegoDeCarrosJava.entity.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Home {
    @Id
    @GeneratedValue
    private Long id;
    private String primerPuesto;
    private String segundoPuesto;
    private String tercerPuesto;

    @Override
    public String toString() {
        return "Home{" +
                "id=" + id +
                ", primerPuesto='" + primerPuesto + '\'' +
                ", segundoPuesto='" + segundoPuesto + '\'' +
                ", tercerPuesto='" + tercerPuesto + '\'' +
                '}';
    }
}
