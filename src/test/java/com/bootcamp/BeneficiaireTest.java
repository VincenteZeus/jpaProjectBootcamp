package com.bootcamp;

import com.bootcamp.jpa.entities.Bailleur;
import com.bootcamp.jpa.entities.Beneficiaire;
import com.bootcamp.jpa.repositories.BaseRepository;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeneficiaireTest extends BaseRepository {

    @Test
    public void createBeneficiaire() throws SQLException {
        BaseRepository<Beneficiaire> beneficiaire = new BaseRepository<Beneficiaire>("tpJpa", Beneficiaire.class);
        Beneficiaire test = new Beneficiaire();
        test.setNom("Vincent");
         if (beneficiaire.create(test)) {
           System.out.println("Création d'un bénéficiaire réussi");
       }
    }

    @Test
    public void findByProgrammeSql() throws SQLException {
        BaseRepository<Beneficiaire> base = new BaseRepository<Beneficiaire>("tpJpa", Beneficiaire.class);
        List<Beneficiaire> beneficiaires = new ArrayList<Beneficiaire>();
        beneficiaires = base.findManyByProperty("Programme", "programme");
        if(beneficiaires.isEmpty())
            System.out.println("Aucun bénéficiaire disponible pour ce programme");
        else {
            System.out.println("Les noms des bénéficiaires disponibles pour ce programme sont :");
            for(int i=0; i<beneficiaires.size(); i++) {
                System.out.println(beneficiaires.get(i).getNom());
            }
        }
    }

    @Test
    public void findByProjetSql() throws SQLException {
        BaseRepository<Beneficiaire> base = new BaseRepository<Beneficiaire>("tpJpa", Beneficiaire.class);
        List<Beneficiaire> beneficiaires = new ArrayList<Beneficiaire>();
        beneficiaires = base.findManyByProperty("Projet", "projet");
        if(beneficiaires.isEmpty())
            System.out.println("Aucun fournisseur disponible pour ce programme");
        else {
            System.out.println("Les noms des fournisseurs disponibles pour ce programme sont :");
            for(int i=0; i<beneficiaires.size(); i++) {
                System.out.println(beneficiaires.get(i).getNom());
            }
        }
    }
}