package com.bootcamp;

import com.bootcamp.jpa.entities.IndicateurPerformance;
import com.bootcamp.jpa.entities.IndicateurQuantitatif;
import com.bootcamp.jpa.repositories.BaseRepository;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class IndicateurQuantitatifTest extends BaseRepository {

    String puSql = "tpJpaSql";
    String puDerby= "tpJpaDerby";

    @Test
    public void createIndicateurQuantitatifSql() throws SQLException {
        IndicateurPerformance indicateurPerformance = new IndicateurPerformance();
        indicateurPerformance.setNom("Vincent");

        BaseRepository<IndicateurQuantitatif> indicateurQuantitatif = new BaseRepository<IndicateurQuantitatif>(puSql, IndicateurQuantitatif.class);
        IndicateurQuantitatif test = new IndicateurQuantitatif();
        test.setNom("Vincent");
        test.setPropriete("Propriété");
        test.setValeur(125);
        test.setIndicateurPerformance(indicateurPerformance);

        if (indicateurQuantitatif.create(test)) {
            System.out.println("Création d'un indicateur de performance réussi");
        }
    }

    @Test
    public void createIndicateurQuantitatifDerby() throws SQLException {
        IndicateurPerformance indicateurPerformance = new IndicateurPerformance();
        indicateurPerformance.setNom("Vincent");

        BaseRepository<IndicateurQuantitatif> indicateurQuantitatif = new BaseRepository<IndicateurQuantitatif>(puDerby, IndicateurQuantitatif.class);
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