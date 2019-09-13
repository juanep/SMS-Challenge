package com.smschallenge.mutantes.service.Imp;

import com.smschallenge.mutantes.model.Adn;
import com.smschallenge.mutantes.service.ValidacionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("validationService")
public class ValidacionServiceImp implements ValidacionService {

    private static final int SECUENCIA = 4;

    private static final int CANT_LIMITE = 2;

    @Transactional
    @Override
    public boolean isValid(Adn adn) {
        String[] cadenaAdn = adn.getCadena();
        if (cadenaAdn == null) {
            return false;
        }
        final int largo = cadenaAdn.length;
        // N >= 1
        if (largo < 1) {
            return false;
        }
        for (String fila : cadenaAdn) {
            // Tamaño de la matriz N x N
            if (fila.length() != largo) {
                return false;
            }
            // Valida caracteres del Adn: A, T, C, G
            if (!fila.matches("[ATCGatcg]{" + largo + "}")) {
                return false;
            }
        }
        return true;
    }

    private static boolean tieneSecuencia(String linea, int cantConsecutiva) {
        final int largo = linea.length();
        char letra = Character.toUpperCase(linea.charAt(0));
        int count = 1;
        for (int i = 1; i < largo; i++) {
            char sigLetra = Character.toUpperCase(linea.charAt(i));
            if (letra == sigLetra) {
                count++;
            } else {
                letra = sigLetra;
                count = 1;
            }
            if (count == cantConsecutiva) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    @Override
    public boolean isMutant(Adn adn) {
        int cantCadenas = 0;
        String[] filas = adn.getCadena();
        for (String fila : filas) {
            if (tieneSecuencia(fila, SECUENCIA)) {
                cantCadenas++;
                if (cantCadenas >= CANT_LIMITE) {
                    return true;
                }
            }
        }
        String[] columnas = getColumnas(filas);
        for (String columna : columnas) {
            if (tieneSecuencia(columna, SECUENCIA)) {
                cantCadenas++;
                if (cantCadenas >= CANT_LIMITE) {
                    return true;
                }
            }
        }
        List<String> diagonales = getDiagonales(filas).stream().filter(s -> s.length() >= SECUENCIA).collect(Collectors.toList());
        for (String diagonal : diagonales) {
            if (tieneSecuencia(diagonal, SECUENCIA)) {
                cantCadenas++;
                if (cantCadenas >= CANT_LIMITE) {
                    return true;
                }
            }
        }
        List<String> diagInversas = getDiagInversas(filas).stream().filter(s -> s.length() >= SECUENCIA).collect(Collectors.toList());
        for (String antiDiagonal : diagInversas) {
            if (tieneSecuencia(antiDiagonal, SECUENCIA)) {
                cantCadenas++;
                if (cantCadenas >= CANT_LIMITE) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String[] getColumnas(String[] filas) {
        final int largo = filas.length;
        String[] columnas = new String[largo];
        for (int i = 0; i < largo; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < largo; j++) {
                stringBuilder.append(filas[j].charAt(i));
            }
            columnas[i] = stringBuilder.toString();
        }
        return columnas;
    }

    private static String getDiagonal(String[] filas, int x, int y) {
        final int largo = filas.length;
        StringBuilder stringBuilder = new StringBuilder();
        while (x < largo && y < largo) {
            stringBuilder.append(filas[x++].charAt(y++));
        }
        return stringBuilder.toString();
    }

    @Override
    public List<String> getDiagonales(String[] filas) {
        final int largo = filas.length;
        List<String> diagonales = new ArrayList<>();
        for (int fila = largo - 1; fila >= 1; fila--) {
            diagonales.add(getDiagonal(filas, fila, 0));
        }
        for (int col = 0; col < largo; col++) {
            diagonales.add(getDiagonal(filas, 0, col));
        }
        return new ArrayList<>(diagonales);
    }

    private static String getAntiDiagonal(String[] filas, int x, int y) {
        final int limite = x;
        StringBuilder stringBuilder = new StringBuilder();
        while (x >= 0 && y <= limite) {
            stringBuilder.append(filas[x--].charAt(y++));
        }
        return stringBuilder.toString();
    }

    @Override
    public List<String> getDiagInversas(String[] filas) {
        final int largo = filas.length;
        List<String> diagonales = new ArrayList<>();
        for (int fila = 0; fila < largo; fila++) {
            diagonales.add(getAntiDiagonal(filas, fila, 0));
        }
        for (int col = 1; col < largo; col++) {
            diagonales.add(getAntiDiagonal(filas, largo - 1, col));
        }
        return new ArrayList<>(diagonales);
    }

}
