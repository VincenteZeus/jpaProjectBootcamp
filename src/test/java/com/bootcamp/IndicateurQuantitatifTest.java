package com.bootcamp;

import com.bootcamp.jpa.entities.IndicateurPerformance;
import com.bootcamp.jpa.entities.IndicateurQuantitatif;
import com.bootcamp.jpa.repositories.BaseRepository;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class IndicateurQuantitatifTest extends BaseRepository {

    @Test
    public void createIndicateurQuantitatif() throws SQLException {
        IndicateurPerformance indicateurPerformance = new IndicateurPerformance();
        indicateurPerformance.setNom("Vincent");

        BaseRepository<IndicateurQuantitatif> indicateurQuantitatif = new BaseRepository<IndicateurQuantitatif>("tpJpa", IndicateurQuantitatif.class);
        IndicateurQuantitatif test = new IndicateurQuantitatif();
        test.setNom("Vincent");
        test.setPropriete("Propriété");
        test.setValeur(125);
        test.setIndicateurPerformance(indicateurPerformance);

        if (indicateurQuantitatif.create(test)) {
            System.out.println("Création d'un indicateur de performance réussi");
        }
    }
}