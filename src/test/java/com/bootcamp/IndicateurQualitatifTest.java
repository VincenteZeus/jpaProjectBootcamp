package com.bootcamp;

import com.bootcamp.jpa.entities.IndicateurPerformance;
import com.bootcamp.jpa.entities.IndicateurQualitatif;
import com.bootcamp.jpa.repositories.BaseRepository;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class IndicateurQualitatifTest extends BaseRepository {

    @Test
    public void createIndicateurQualitatif() throws SQLException {
        IndicateurPerformance indicateurPerformance = new IndicateurPerformance();
        indicateurPerformance.setNom("Vincent");

        BaseRepository<IndicateurQualitatif> indicateurQualitatif = new BaseRepository<IndicateurQualitatif>("tpJpa", IndicateurQualitatif.class);
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