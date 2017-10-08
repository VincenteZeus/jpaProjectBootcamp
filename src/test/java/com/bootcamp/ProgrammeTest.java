package com.bootcamp;

import com.bootcamp.jpa.entities.IndicateurPerformance;
import com.bootcamp.jpa.entities.IndicateurQualitatif;
import com.bootcamp.jpa.entities.Programme;
import com.bootcamp.jpa.entities.Projet;
import com.bootcamp.jpa.repositories.BaseRepository;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class ProgrammeTest extends BaseRepository {

    String puSql = "tpJpaSql";
    String puDerby= "tpJpaDerby";

    @Test
    public Programme createProgrammeSql() throws SQLException {
        Date date1 = new Date();
        Date date2 = new Date();
        IndicateurPerformance indicateurPerformance = new IndicateurPerformance();
        indicateurPerformance.setNom("Vincent");
        Projet projet = new Projet();


        BaseRepository<Programme> programme = new BaseRepository<Programme>(puSql, Programme.class);
        Programme test = new Programme();
        test.setNom("Vincent");
        test.setObjectif("Objectif");
        test.setDateDeDebut(date1);
        test.setDateDeFin(date2);
        test.setBudgetPrevisionnel(7584);
        test.setBudgetEffectif(1254);
        test.setIndicateurPerformance(indicateurPerformance);

         if (programme.create(test))
           System.out.println("Création d'un programme réussi");
         return test;
    }

    @Test
    public void createJsonFile() throws SQLException {
        Programme test = createProgrammeSql();
        Gson gson = new Gson();
        String json = gson.toJson(test);
        System.out.println(json);
        try (FileWriter writer = new FileWriter("json/programmes.json")) {
            gson.toJson(test, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createProgrammeDerby() throws SQLException {
        Date date1 = new Date();
        Date date2 = new Date();
        IndicateurPerformance indicateurPerformance = new IndicateurPerformance();
        indicateurPerformance.setNom("Vincent");
        Projet projet = new Projet();


        BaseRepository<Programme> programme = new BaseRepository<Programme>(puDerby, Programme.class);
        Programme test = new Programme();
        test.setNom("Vincent");
        test.setObjectif("Objectif");
        test.setDateDeDebut(date1);
        test.setDateDeFin(date2);
        test.setBudgetPrevisionnel(7584);
        test.setBudgetEffectif(1254);
        test.setIndicateurPerformance(indicateurPerformance);

        if (programme.create(test)) {
            System.out.println("Création d'un programme réussi");
        }
    }
}