package com.bootcamp;

import com.bootcamp.jpa.entities.IndicateurPerformance;
import com.bootcamp.jpa.entities.IndicateurQualitatif;
import com.bootcamp.jpa.repositories.BaseRepository;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class IndicateurQualitatifTest extends BaseRepository {

    String puSql = "tpJpaSql";
    String puDerby= "tpJpaDerby";

    @Test
    public void createIndicateurQualitatifSql() throws SQLException {
        IndicateurPerformance indicateurPerformance = new IndicateurPerformance();
        indicateurPerformance.setNom("Vincent");

        BaseRepository<IndicateurQualitatif> indicateurQualitatif = new BaseRepository<IndicateurQualitatif>(puSql, IndicateurQualitatif.class);
        IndicateurQualitatif test = new IndicateurQualitatif();
        test.setNom("Vincent");
        test.setPropriete("Propriété");
        test.setValeur("Valeur");
        test.setIndicateurPerformance(indicateurPerformance);

         if (indicateurQualitatif.create(test)) {
           System.out.println("Création d'un indicateur de performance réussi");
       }
    }

    @Test
    public void createIndicateurQualitatifDerby() throws SQLException {
        IndicateurPerformance indicateurPerformance = new IndicateurPerformance();
        indicateurPerformance.setNom("Vincent");

        BaseRepository<IndicateurQualitatif> indicateurQualitatif = new BaseRepository<IndicateurQualitatif>(puDerby, IndicateurQualitatif.class);
        IndicateurQualitatif test = new IndicateurQualitatif();
        test.setNom("Vincent");
        test.setPropriete("Propriété");
        test.setValeur("Valeur");
        test.setIndicateurPerformance(indicateurPerformance);

        if (indicateurQualitatif.create(test)) {
            System.out.println("Création d'un indicateur de performance réussi");
        }
    }
}