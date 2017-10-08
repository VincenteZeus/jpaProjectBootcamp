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

public class ProjetTest extends BaseRepository {

    String puSql = "tpJpaSql";
    String puDerby= "tpJpaDerby";

    @Test
    public Projet createProjetSql() throws SQLException {
        Date date1 = new Date();
        Date date2 = new Date();
        IndicateurPerformance indicateurPerformance = new IndicateurPerformance();
        indicateurPerformance.setNom("Vincent");
        Programme programme = new Programme();
        programme.setNom("Vincent");
        programme.setObjectif("Objectif");
        programme.setDateDeDebut(date1);
        programme.setDateDeFin(date2);
        programme.setBudgetPrevisionnel(7584);
        programme.setBudgetEffectif(1254);
        programme.setIndicateurPerformance(indicateurPerformance);


        BaseRepository<Projet> projet = new BaseRepository<Projet>(puSql, Projet.class);
        Projet test = new Projet();
        test.setNom("Vincent");
        test.setObjectif("Objectif");
        test.setDateDeDebut(date1);
        test.setDateDeFin(date2);
        test.setBudgetPrevisionnel(15400);
        test.setBudgetEffectif(1254);
        test.setProgramme(programme);

        if (projet.create(test))
           System.out.println("Création d'un projet réussi");
        return test;
    }

    @Test
    public void createJsonFile() throws SQLException {
        Projet test = createProjetSql();
        Gson gson = new Gson();
        String json = gson.toJson(test);
        System.out.println(json);
        try (FileWriter writer = new FileWriter("json/projets.json")) {
            gson.toJson(test, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createProjetDerby() throws SQLException {
        Date date1 = new Date();
        Date date2 = new Date();
        IndicateurPerformance indicateurPerformance = new IndicateurPerformance();
        indicateurPerformance.setNom("Vincent");
        Programme programme = new Programme();
        programme.setNom("Vincent");
        programme.setObjectif("Objectif");
        programme.setDateDeDebut(date1);
        programme.setDateDeFin(date2);
        programme.setBudgetPrevisionnel(7584);
        programme.setBudgetEffectif(1254);
        programme.setIndicateurPerformance(indicateurPerformance);


        BaseRepository<Projet> projet = new BaseRepository<Projet>(puDerby, Projet.class);
        Projet test = new Projet();
        test.setNom("Vincent");
        test.setObjectif("Objectif");
        test.setDateDeDebut(date1);
        test.setDateDeFin(date2);
        test.setBudgetPrevisionnel(15400);
        test.setBudgetEffectif(1254);
        test.setProgramme(programme);

        if (projet.create(test)) {
            System.out.println("Création d'un projet réussi");
        }
    }
}