package com.bootcamp;

import com.bootcamp.jpa.entities.IndicateurPerformance;
import com.bootcamp.jpa.entities.IndicateurQualitatif;
import com.bootcamp.jpa.entities.IndicateurQuantitatif;
import com.bootcamp.jpa.repositories.BaseRepository;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class IndicateurQuantitatifTest extends BaseRepository {

    String puSql = "tpJpaSql";
    String puDerby= "tpJpaDerby";

    @Test
    public IndicateurQuantitatif createIndicateurQuantitatifSql() throws SQLException {
        IndicateurPerformance indicateurPerformance = new IndicateurPerformance();
        indicateurPerformance.setNom("Vincent");

        BaseRepository<IndicateurQuantitatif> indicateurQuantitatif = new BaseRepository<IndicateurQuantitatif>(puSql, IndicateurQuantitatif.class);
        IndicateurQuantitatif test = new IndicateurQuantitatif();
        test.setNom("Vincent");
        test.setPropriete("Propriété");
        test.setValeur(125);
        test.setIndicateurPerformance(indicateurPerformance);

        if (indicateurQuantitatif.create(test))
            System.out.println("Création d'un indicateur de performance réussi");
        return test;
    }

    @Test
    public void createJsonFile() throws SQLException {
        IndicateurQuantitatif test = createIndicateurQuantitatifSql();
        Gson gson = new Gson();
        String json = gson.toJson(test);
        System.out.println(json);
        try (FileWriter writer = new FileWriter("json/quantites.json")) {
            gson.toJson(test, writer);

        } catch (IOException e) {
            e.printStackTrace();
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