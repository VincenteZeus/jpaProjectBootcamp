package com.bootcamp;

import com.bootcamp.jpa.entities.*;
import com.bootcamp.jpa.repositories.BaseRepository;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class LivrableTest extends BaseRepository {

    String puSql = "tpJpaSql";
    String puDerby= "tpJpaDerby";

    @Test
    public Livrable createLivrableSql() throws SQLException {
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

        Projet projet = new Projet();
        projet.setNom("Vincent");
        projet.setObjectif("Objectif");
        projet.setDateDeDebut(date1);
        projet.setDateDeFin(date2);
        projet.setBudgetPrevisionnel(15400);
        projet.setBudgetEffectif(1254);
        projet.setProgramme(programme);

        BaseRepository<Livrable> livrable = new BaseRepository<Livrable>(puSql, Livrable.class);
        Livrable test = new Livrable();
        test.setNom("Vincent");
        test.setDateDeDebut(date1);
        test.setDateDeLivraison(date2);
        test.setIndicateurPerformance(indicateurPerformance);
        test.setProjet(projet);
        if (livrable.create(test))
           System.out.println("Création d'un livrable réussi");
        return test;
    }

    @Test
    public void createJsonFile() throws SQLException {
        Livrable test = createLivrableSql();
        Gson gson = new Gson();
        String json = gson.toJson(test);
        System.out.println(json);
        try (FileWriter writer = new FileWriter("json/livrables.json")) {
            gson.toJson(test, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createLivrableDerby() throws SQLException {
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

        Projet projet = new Projet();
        projet.setNom("Vincent");
        projet.setObjectif("Objectif");
        projet.setDateDeDebut(date1);
        projet.setDateDeFin(date2);
        projet.setBudgetPrevisionnel(15400);
        projet.setBudgetEffectif(1254);
        projet.setProgramme(programme);

        BaseRepository<Livrable> livrable = new BaseRepository<Livrable>(puDerby, Livrable.class);
        Livrable test = new Livrable();
        test.setNom("Vincent");
        test.setDateDeDebut(date1);
        test.setDateDeLivraison(date2);
        test.setIndicateurPerformance(indicateurPerformance);
        test.setProjet(projet);
        if (livrable.create(test)) {
            System.out.println("Création d'un livrable réussi");
        }
    }
}