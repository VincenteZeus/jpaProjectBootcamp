package com.bootcamp;

import com.bootcamp.jpa.entities.*;
import com.bootcamp.jpa.repositories.BaseRepository;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FournisseurTest extends BaseRepository {

    String puSql = "tpJpaSql";
    String puDerby= "tpJpaDerby";

    @Test
    public void createFournisseurSql() throws SQLException {
        BaseRepository<Fournisseur> fournisseur = new BaseRepository<Fournisseur>(puSql, Fournisseur.class);
        Fournisseur test = new Fournisseur();
        test.setNom("Vincent");
         if (fournisseur.create(test)) {
           System.out.println("Création d'un fournisseur réussi");
       }
    }

    public void getFournisseursByProgrammeSql() throws SQLException {
        BaseRepository<Fournisseur_has_Programme> instance = new BaseRepository<Fournisseur_has_Programme>(puSql, Fournisseur_has_Programme.class);
        Programme programme = new Programme();
        programme.setNom("Vincent");
        List<Fournisseur_has_Programme> result = instance.findEntitiesByProperty(programme.getId(), "programme_id");
        List<Fournisseur> fournisseurs = new LinkedList<Fournisseur>() ;
        for (int i=0; i<result.size();i++)
        {
            Fournisseur entite = result.get(i).getFournisseur();
            fournisseurs.add(entite);
        }
        if(fournisseurs.isEmpty())
            System.out.println("Il n'existe aucun fournisseur pour ce programme");
        else {
            System.out.println("Les noms des fournisseurs de ce programme sont :");
            for (int i=0; i<fournisseurs.size(); i++) {
                System.out.println(fournisseurs.get(i).getNom());
            }
        }
    }

    public void getFournisseursByProjetSql() throws SQLException {
        BaseRepository<Fournisseur_has_Projet> instance = new BaseRepository<Fournisseur_has_Projet>(puSql, Fournisseur_has_Projet.class);
        Projet projet = new Projet();
        projet.setNom("Vincent");
        List<Fournisseur_has_Projet> result = instance.findEntitiesByProperty(projet.getId(), "projet_id");
        List<Fournisseur> fournisseurs = new LinkedList<Fournisseur>() ;
        for (int i=0; i<result.size();i++)
        {
            Fournisseur entite = result.get(i).getFournisseur();
            fournisseurs.add(entite);
        }
        if(fournisseurs.isEmpty())
            System.out.println("Il n'existe aucun fournisseur pour ce programme");
        else {
            System.out.println("Les noms des fournisseurs de ce programme sont :");
            for (int i=0; i<fournisseurs.size(); i++) {
                System.out.println(fournisseurs.get(i).getNom());
            }
        }
    }

    @Test
    public void createFournisseurDerby() throws SQLException {
        BaseRepository<Fournisseur> fournisseur = new BaseRepository<Fournisseur>(puDerby, Fournisseur.class);
        Fournisseur test = new Fournisseur();
        test.setNom("Vincent");
        if (fournisseur.create(test)) {
            System.out.println("Création d'un fournisseur réussi");
        }
    }

    public void getFournisseursByProgrammeDerby() throws SQLException {
        BaseRepository<Fournisseur_has_Programme> instance = new BaseRepository<Fournisseur_has_Programme>(puDerby, Fournisseur_has_Programme.class);
        Programme programme = new Programme();
        programme.setNom("Vincent");
        List<Fournisseur_has_Programme> result = instance.findEntitiesByProperty(programme.getId(), "programme_id");
        List<Fournisseur> fournisseurs = new LinkedList<Fournisseur>() ;
        for (int i=0; i<result.size();i++)
        {
            Fournisseur entite = result.get(i).getFournisseur();
            fournisseurs.add(entite);
        }
        if(fournisseurs.isEmpty())
            System.out.println("Il n'existe aucun fournisseur pour ce programme");
        else {
            System.out.println("Les noms des fournisseurs de ce programme sont :");
            for (int i=0; i<fournisseurs.size(); i++) {
                System.out.println(fournisseurs.get(i).getNom());
            }
        }
    }

    public void getFournisseursByProjetDerby() throws SQLException {
        BaseRepository<Fournisseur_has_Projet> instance = new BaseRepository<Fournisseur_has_Projet>(puDerby, Fournisseur_has_Projet.class);
        Projet projet = new Projet();
        projet.setNom("Vincent");
        List<Fournisseur_has_Projet> result = instance.findEntitiesByProperty(projet.getId(), "projet_id");
        List<Fournisseur> fournisseurs = new LinkedList<Fournisseur>() ;
        for (int i=0; i<result.size();i++)
        {
            Fournisseur entite = result.get(i).getFournisseur();
            fournisseurs.add(entite);
        }
        if(fournisseurs.isEmpty())
            System.out.println("Il n'existe aucun fournisseur pour ce programme");
        else {
            System.out.println("Les noms des fournisseurs de ce programme sont :");
            for (int i=0; i<fournisseurs.size(); i++) {
                System.out.println(fournisseurs.get(i).getNom());
            }
        }
    }
}