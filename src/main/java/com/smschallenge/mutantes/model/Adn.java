package com.smschallenge.mutantes.model;

import javax.persistence.*;

@Entity
@Table(name = "adns")
public class Adn {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String[] cadena;

    public String[] getCadena() {
        return cadena;
    }

    public Long getId() {
        return id;
    }

}
