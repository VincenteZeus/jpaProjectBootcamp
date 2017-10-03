package com.bootcamp;

import com.bootcamp.jpa.entities.Bailleur;
import com.bootcamp.jpa.entities.Fournisseur;
import com.bootcamp.jpa.repositories.BaseRepository;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FournisseurTest extends BaseRepository {

    @Test
    public void createFournisseur() throws SQLException {
        BaseRepository<Fournisseur> fournisseur = new BaseRepository<Fournisseur>("tpJpa", Fournisseur.class);
        Fournisseur test = new Fournisseur();
        test.setNom("Vincent");
         if (fournisseur.create(test)) {
           System.out.println("Création d'un fournisseur réussi");
       }
    }

    @Test
    public void findByProgrammeSql() throws SQLException {
        BaseRepository<Fournisseur> base = new BaseRepository<Fournisseur>("tpJpa", Fournisseur.class);
        List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
        fournisseurs = base.findManyByProperty("Programme", "programme");
        if(fournisseurs.isEmpty())
            System.out.println("Aucun fournisseur disponible pour ce programme");
        else {
            System.out.println("Les noms des fournisseurs disponibles pour ce programme sont :");
            for(int i=0; i<fournisseurs.size(); i++) {
                System.out.println(fournisseurs.get(i).getNom());
            }
        }
    }

    @Test
    public void findByBeneficiaireSql() throws SQLException {
        BaseRepository<Fournisseur> base = new BaseRepository<Fournisseur>("tpJpa", Fournisseur.class);
        List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
        fournisseurs = base.findManyByProperty("Projet", "projet");
        if(fournisseurs.isEmpty())
            System.out.println("Aucun fournisseur disponible pour ce projet");
        else {
            System.out.println("Les noms des fournisseurs disponibles pour ce projet sont :");
            for(int i=0; i<fournisseurs.size(); i++) {
                System.out.println(fournisseurs.get(i).getNom());
            }
        }
    }
}