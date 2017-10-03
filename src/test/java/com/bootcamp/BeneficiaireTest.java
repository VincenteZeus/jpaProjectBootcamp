package com.bootcamp;

import com.bootcamp.jpa.entities.*;
import com.bootcamp.jpa.repositories.BaseRepository;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BeneficiaireTest extends BaseRepository {

    String puSql = "tpJpaSql";
    String puDerby= "tpJpaDerby";

    @Test
    public void createBeneficiaireSql() throws SQLException {
        BaseRepository<Beneficiaire> beneficiaire = new BaseRepository<Beneficiaire>(puSql, Beneficiaire.class);
        Beneficiaire test = new Beneficiaire();
        test.setNom("Vincent");
         if (beneficiaire.create(test)) {
           System.out.println("Création d'un bénéficiaire réussi");
       }
    }

    public void getBeneficiairesByProgrammeSql() throws SQLException {
        BaseRepository<Beneficiaire_has_Programme> instance = new BaseRepository<Beneficiaire_has_Programme>(puSql, Beneficiaire_has_Programme.class);
        Programme programme = new Programme();
        programme.setNom("Vincent");
        List<Beneficiaire_has_Programme> result = instance.findEntitiesByProperty(programme.getId(), "programme_id");
        List<Beneficiaire> beneficiaires = new LinkedList<Beneficiaire>() ;
        for (int i=0; i<result.size();i++)
        {
            Beneficiaire entite = result.get(i).getBeneficiaire();
            beneficiaires.add(entite);
        }
        if(beneficiaires.isEmpty())
            System.out.println("Il n'existe aucun bénéficiaire pour ce programme");
        else {
            System.out.println("Les noms des bénéficiaires de ce programme sont :");
            for (int i=0; i<beneficiaires.size(); i++) {
                System.out.println(beneficiaires.get(i).getNom());
            }
        }
    }

    public void getBeneficiairesByProjetSql() throws SQLException {
        BaseRepository<Beneficiaire_has_Projet> instance = new BaseRepository<Beneficiaire_has_Projet>(puSql, Beneficiaire_has_Projet.class);
        Projet projet = new Projet();
        projet.setNom("Vincent");
        List<Beneficiaire_has_Projet> result = instance.findEntitiesByProperty(projet.getId(), "projet_id");
        List<Beneficiaire> beneficiaires = new LinkedList<Beneficiaire>() ;
        for (int i=0; i<result.size();i++)
        {
            Beneficiaire entite = result.get(i).getBeneficiaire();
            beneficiaires.add(entite);
        }
        if(beneficiaires.isEmpty())
            System.out.println("Il n'existe aucun bénéficiaire pour ce programme");
        else {
            System.out.println("Les noms des bénéficiaires de ce programme sont :");
            for (int i=0; i<beneficiaires.size(); i++) {
                System.out.println(beneficiaires.get(i).getNom());
            }
        }
    }

    @Test
    public void createBeneficiaireDerby() throws SQLException {
        BaseRepository<Beneficiaire> beneficiaire = new BaseRepository<Beneficiaire>(puDerby, Beneficiaire.class);
        Beneficiaire test = new Beneficiaire();
        test.setNom("Vincent");
         if (beneficiaire.create(test)) {
           System.out.println("Création d'un bénéficiaire réussi");
       }
    }

    public void getBeneficiairesByProgrammeDerby() throws SQLException {
        BaseRepository<Beneficiaire_has_Programme> instance = new BaseRepository<Beneficiaire_has_Programme>(puDerby, Beneficiaire_has_Programme.class);
        Programme programme = new Programme();
        programme.setNom("Vincent");
        List<Beneficiaire_has_Programme> result = instance.findEntitiesByProperty(programme.getId(), "programme_id");
        List<Beneficiaire> beneficiaires = new LinkedList<Beneficiaire>() ;
        for (int i=0; i<result.size();i++)
        {
            Beneficiaire entite = result.get(i).getBeneficiaire();
            beneficiaires.add(entite);
        }
        if(beneficiaires.isEmpty())
            System.out.println("Il n'existe aucun bénéficiaire pour ce programme");
        else {
            System.out.println("Les noms des bénéficiaires de ce programme sont :");
            for (int i=0; i<beneficiaires.size(); i++) {
                System.out.println(beneficiaires.get(i).getNom());
            }
        }
    }

    public void getBeneficiairesByProjetDerby() throws SQLException {
        BaseRepository<Beneficiaire_has_Projet> instance = new BaseRepository<Beneficiaire_has_Projet>(puDerby, Beneficiaire_has_Projet.class);
        Projet projet = new Projet();
        projet.setNom("Vincent");
        List<Beneficiaire_has_Projet> result = instance.findEntitiesByProperty(projet.getId(), "projet_id");
        List<Beneficiaire> beneficiaires = new LinkedList<Beneficiaire>() ;
        for (int i=0; i<result.size();i++)
        {
            Beneficiaire entite = result.get(i).getBeneficiaire();
            beneficiaires.add(entite);
        }
        if(beneficiaires.isEmpty())
            System.out.println("Il n'existe aucun bénéficiaire pour ce programme");
        else {
            System.out.println("Les noms des bénéficiaires de ce programme sont :");
            for (int i=0; i<beneficiaires.size(); i++) {
                System.out.println(beneficiaires.get(i).getNom());
            }
        }
    }
}