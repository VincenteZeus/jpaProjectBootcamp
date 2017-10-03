package com.bootcamp;

import com.bootcamp.jpa.entities.IndicateurPerformance;
import com.bootcamp.jpa.entities.Programme;
import com.bootcamp.jpa.entities.Projet;
import com.bootcamp.jpa.repositories.BaseRepository;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Date;

public class ProgrammeTest extends BaseRepository {

    @Test
    public void createProgramme() throws SQLException {
        Date date1 = new Date();
        Date date2 = new Date();
        IndicateurPerformance indicateurPerformance = new IndicateurPerformance();
        indicateurPerformance.setNom("Vincent");
        Projet projet = new Projet();


        BaseRepository<Programme> programme = new BaseRepository<Programme>("tpJpa", Programme.class);
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