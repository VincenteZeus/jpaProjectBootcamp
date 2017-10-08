package com.bootcamp;

import com.bootcamp.jpa.entities.Fournisseur;
import com.bootcamp.jpa.entities.IndicateurPerformance;
import com.bootcamp.jpa.repositories.BaseRepository;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class IndicateurPerformanceTest extends BaseRepository {

    String puSql = "tpJpaSql";
    String puDerby= "tpJpaDerby";

    @Test
    public IndicateurPerformance createIndicateurPerformanceSql() throws SQLException {
        BaseRepository<IndicateurPerformance> indicateurPerformance = new BaseRepository<IndicateurPerformance>(puSql, IndicateurPerformance.class);
        IndicateurPerformance test = new IndicateurPerformance();
        test.setNom("Vincent");
        if (indicateurPerformance.create(test))
           System.out.println("Création d'un indicateur de performance réussi");
        return test;
    }

    @Test
    public void createJsonFile() throws SQLException {
        IndicateurPerformance test = createIndicateurPerformanceSql();
        Gson gson = new Gson();
        String json = gson.toJson(test);
        System.out.println(json);
        try (FileWriter writer = new FileWriter("json/performances.json")) {
            gson.toJson(test, writer);

        } catch (IOException e) {
            e.printStackTrace();
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