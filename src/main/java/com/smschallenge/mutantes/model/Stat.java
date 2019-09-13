package com.smschallenge.mutantes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stats")
public class Stat {

    @Id
    private Long id = 0L;

    @Column(nullable = false)
    private Long cantMutantes;

    @Column(nullable = false)
    private Long cantHumanos;

    public Long getId() {
        return id;
    }

    public Long getCantMutantes() {
        return cantMutantes;
    }

    void setCantMutantes(Long mutantCount) {
        this.cantMutantes = mutantCount;
    }

    public Long getCantHumanos() {
        return cantHumanos;
    }

    void setCantHumanos(Long humanCount) {
        this.cantHumanos = humanCount;
    }

    public Double getRatio() {
        if (getCantHumanos() == 0) {
            return (getCantMutantes() != 0) ? 1.0 : 0.0;
        }
        return (double) getCantMutantes() / (double) getCantHumanos();
    }
}
