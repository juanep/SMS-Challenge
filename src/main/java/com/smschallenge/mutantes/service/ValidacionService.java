package com.smschallenge.mutantes.service;

import com.smschallenge.mutantes.model.Adn;

import java.util.List;

public interface ValidacionService {

    public boolean isValid(Adn adn);

    public boolean isMutant(Adn adn);

    public String[] getColumnas(String[] filas);

    public List<String> getDiagonales(String[] filas);

    public List<String> getDiagInversas(String[] rows);

}
