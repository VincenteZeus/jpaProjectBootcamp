package com.bootcamp;

import com.bootcamp.jpa.entities.IndicateurPerformance;
import com.bootcamp.jpa.repositories.BaseRepository;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class IndicateurPerformanceTest extends BaseRepository {

    @Test
    public void createIndicateurPerformance() throws SQLException {
        BaseRepository<IndicateurPerformance> indicateurPerformance = new BaseRepository<IndicateurPerformance>("tpJpa", IndicateurPerformance.class);
        IndicateurPerformance test = new IndicateurPerformance();
        test.setNom("Vincent");
         if (indicateurPerformance.create(test)) {
           System.out.println("Création d'un indicateur de performance réussi");
       }
    }
}