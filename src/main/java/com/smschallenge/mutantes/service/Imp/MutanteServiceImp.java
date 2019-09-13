package com.smschallenge.mutantes.service.Imp;

import com.smschallenge.mutantes.model.*;
import com.smschallenge.mutantes.repository.AdnRepository;
import com.smschallenge.mutantes.repository.StatRepository;
import com.smschallenge.mutantes.service.MutanteService;
import com.smschallenge.mutantes.service.ValidacionService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("mutanteService")
public class MutanteServiceImp implements MutanteService {

    @Autowired
    private AdnRepository adnRepository;

    @Autowired
    private StatRepository statRepository;

    @Autowired
    private ValidacionService validacionService;

    @Transactional
    @Override
    public boolean esMutante(Adn adn) throws ServiceException {
        if (validacionService.isValid(adn)) {
            boolean esMutante = validacionService.isMutant(adn);
            if (validacionService.isMutant(adn)) {
                statRepository.incrementar(Gen.MUTANTE);
            } else {
                statRepository.incrementar(Gen.HUMANO);
            }
            adnRepository.save(adn);
            return esMutante;
        } else
            throw new ServiceException();
    }

    @Override
    public Stat getStats() {
        return statRepository.getStat();
    }
}
