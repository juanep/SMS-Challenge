package com.smschallenge.mutantes.service;

import com.smschallenge.mutantes.model.Adn;
import com.smschallenge.mutantes.model.Stat;
import org.hibernate.service.spi.ServiceException;

public interface MutanteService {

    boolean esMutante(Adn dna) throws ServiceException;

    Stat getStats();
}
