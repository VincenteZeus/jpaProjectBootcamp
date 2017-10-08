package com.bootcamp;

import com.bootcamp.jpa.entities.IndicateurPerformance;
import com.bootcamp.jpa.entities.IndicateurQualitatif;
import com.bootcamp.jpa.repositories.BaseRepository;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class IndicateurQualitatifTest extends BaseRepository {

    String puSql = "tpJpaSql";
    String puDerby= "tpJpaDerby";

    @Test
    public IndicateurQualitatif createIndicateurQualitatifSql() throws SQLException {
        IndicateurPerformance indicateurPerformance = new IndicateurPerformance();
        indicateurPerformance.setNom("Vincent");

        BaseRepository<IndicateurQualitatif> indicateurQualitatif = new BaseRepository<IndicateurQualitatif>(puSql, IndicateurQualitatif.class);
        IndicateurQualitatif test = new IndicateurQualitatif();
        test.setNom("Vincent");
        test.setPropriete("Propriété");
        test.setValeur("Valeur");
        test.setIndicateurPerformance(indicateurPerformance);

        if (indicateurQualitatif.create(test))
           System.out.println("Création d'un indicateur de qualité réussi");
        return test;
    }

    @Test
    public void createJsonFile() throws SQLException {
        IndicateurQualitatif test = createIndicateurQualitatifSql();
        Gson gson = new Gson();
        String json = gson.toJson(test);
        System.out.println(json);
        try (FileWriter writer = new FileWriter("json/qualites.json")) {
            gson.toJson(test, writer);

        } catch (IOException e) {
            e.printStackTrace();
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