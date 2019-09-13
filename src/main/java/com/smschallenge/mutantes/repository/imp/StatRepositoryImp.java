package com.smschallenge.mutantes.repository.imp;

import com.smschallenge.mutantes.model.Gen;
import com.smschallenge.mutantes.model.Stat;
import com.smschallenge.mutantes.repository.StatRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository("statRepository")
public class StatRepositoryImp implements StatRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Stat getStat() {
        Stat stat = em.find(Stat.class, 0L);
        if (stat == null) {
            em.persist(new Stat());
        }
        return stat;
    }

    @Transactional
    @Override
    public void incrementar(Gen gen) {
        getStat();
        String query;
        if (Gen.MUTANTE.equals(gen)){
            query = "UPDATE Stats s set s.mutantCount = s.mutantCount + 1 WHERE s.id = 0";
        } else {
            query = "UPDATE Stats s set s.humanCount = s.humanCount + 1 WHERE s.id = 0";
        }
        em.createQuery(query).executeUpdate();
    }

    @Transactional
    @Override
    public void reset() {
        getStat();
        String query = "UPDATE Stats s set s.humanCount = 0, s.mutantCount = 0 WHERE s.id = 0";
        em.createQuery(query).executeUpdate();
    }

}
