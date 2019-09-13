package com.smschallenge.mutantes.repository;

import com.smschallenge.mutantes.model.Gen;
import com.smschallenge.mutantes.model.Stat;

public interface StatRepository {

    Stat getStat();

    void incrementar(Gen gen);

    void reset();

}
