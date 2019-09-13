package com.smschallenge.mutantes.repository;

import com.smschallenge.mutantes.model.Adn;
import com.smschallenge.mutantes.service.ValidacionService;
import org.springframework.data.repository.CrudRepository;

public interface AdnRepository extends CrudRepository<Adn, Long>, ValidacionService {
    
}
