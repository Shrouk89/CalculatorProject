package com.lab.task.repo;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;


import com.lab.task.model.Calculation;

@Stateless
public class CalculationRepo {
    @PersistenceContext
    private EntityManager entity_Manager;

    public CalculationRepo() {
    }

    public void insert(Calculation calc) {
        entity_Manager.persist(calc);
    }

    public List<Calculation> selectAll() {
        return entity_Manager.createQuery("select c from Calculation c", Calculation.class).getResultList();
    }
}