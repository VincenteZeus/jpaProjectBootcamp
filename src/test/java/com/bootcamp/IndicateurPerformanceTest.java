package com.bootcamp;

import com.bootcamp.jpa.entities.IndicateurPerformance;
import com.bootcamp.jpa.repositories.BaseRepository;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class IndicateurPerformanceTest extends BaseRepository {

    String puSql = "tpJpaSql";
    String puDerby= "tpJpaDerby";

    @Test
    public void createIndicateurPerformanceSql() throws SQLException {
        BaseRepository<IndicateurPerformance> indicateurPerformance = new BaseRepository<IndicateurPerformance>(puSql, IndicateurPerformance.class);
        IndicateurPerformance test = new IndicateurPerformance();
        test.setNom("Vincent");
         if (indicateurPerformance.create(test)) {
           System.out.println("Création d'un indicateur de performance réussi");
       }
    }

    @Test
    public void createIndicateurPerformanceDerby() throws SQLException {
        BaseRepository<IndicateurPerformance> indicateurPerformance = new BaseRepository<IndicateurPerformance>(puDerby, IndicateurPerformance.class);
        IndicateurPerformance test = new IndicateurPerformance();
        test.setNom("Vincent");
        if (indicateurPerformance.create(test)) {
            System.out.println("Création d'un indicateur de performance réussi");
        }
    }
}