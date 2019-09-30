package com.fuel.consumption.repository;

import com.fuel.consumption.domain.FuelTab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BulkInsertRepository extends SimpleJpaRepository<FuelTab, Long> {

    private EntityManager entityManager;

    @Autowired
    public BulkInsertRepository(EntityManager entityManager) {
        super(FuelTab.class, entityManager);
        this.entityManager=entityManager;
    }

    @Transactional
    public List<FuelTab> save(List<FuelTab> fuelTabs) {
        fuelTabs.forEach(fuelTab -> entityManager.persist(fuelTab));
        return fuelTabs;
    }
}
