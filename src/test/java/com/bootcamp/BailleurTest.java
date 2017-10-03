package com.bootcamp;

import com.bootcamp.jpa.entities.*;
import com.bootcamp.jpa.enums.TypeDeBailleur;
import com.bootcamp.jpa.repositories.BaseRepository;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BailleurTest extends BaseRepository {

    String puSql = "tpJpaSql";
    String puDerby= "tpJpaDerby";

    @Test
    public void createBailleurSql() throws SQLException {
        BaseRepository<Bailleur> bailleur = new BaseRepository<Bailleur>(puSql, Bailleur.class);
        Bailleur test = new Bailleur();
        test.setNom("Vincent");
        test.setTypeDeBailleur(TypeDeBailleur.gouvernementale);
        if (bailleur.create(test))
            System.out.println("Création d'un bailleur réussi");
    }

    public void getBailleursByProgrammeSql() throws SQLException {
        BaseRepository<Bailleur_has_Programme> instance = new BaseRepository<Bailleur_has_Programme>(puSql, Bailleur_has_Programme.class);
        Programme programme = new Programme();
        programme.setNom("Vincent");
        List<Bailleur_has_Programme> result = instance.findEntitiesByProperty(programme.getId(), "programme_id");
        List<Bailleur> bailleurs = new LinkedList<Bailleur>() ;
        for (int i=0; i<result.size();i++)
        {
            Bailleur entite = result.get(i).getBailleur();
            bailleurs.add(entite);
        }
        if(bailleurs.isEmpty())
            System.out.println("Il n'existe aucun bailleur pour ce programme");
        else {
            System.out.println("Les noms des bailleurs de ce programme sont :");
            for (int i=0; i<bailleurs.size(); i++) {
                System.out.println(bailleurs.get(i).getNom());
            }
        }
    }

    public void getBailleursByProjetSql() throws SQLException {
        BaseRepository<Bailleur_has_Projet> instance = new BaseRepository<Bailleur_has_Projet>(puSql, Bailleur_has_Projet.class);
        Projet projet = new Projet();
        projet.setNom("Vincent");
        List<Bailleur_has_Projet> result = instance.findEntitiesByProperty(projet.getId(), "projet_id");
        List<Bailleur> bailleurs = new LinkedList<Bailleur>() ;
        for (int i=0; i<result.size();i++)
        {
            Bailleur entite = result.get(i).getBailleur();
            bailleurs.add(entite);
        }
        if(bailleurs.isEmpty())
            System.out.println("Il n'existe aucun bailleur pour ce programme");
        else {
            System.out.println("Les noms des bailleurs de ce programme sont :");
            for (int i=0; i<bailleurs.size(); i++) {
                System.out.println(bailleurs.get(i).getNom());
            }
        }
    }

    @Test
    public void createBailleurDerby() throws SQLException {
        BaseRepository<Bailleur> bailleur = new BaseRepository<Bailleur>(puDerby, Bailleur.class);
        Bailleur test = new Bailleur();
        test.setNom("Vincent");
        test.setTypeDeBailleur(TypeDeBailleur.gouvernementale);
        if (bailleur.create(test))
            System.out.println("Création d'un bailleur réussi");
    }

    public void getBailleursByProgrammeDerby() throws SQLException {
        BaseRepository<Bailleur_has_Programme> instance = new BaseRepository<Bailleur_has_Programme>(puDerby, Bailleur_has_Programme.class);
        Programme programme = new Programme();
        programme.setNom("Vincent");
        List<Bailleur_has_Programme> result = instance.findEntitiesByProperty(programme.getId(), "programme_id");
        List<Bailleur> bailleurs = new LinkedList<Bailleur>() ;
        for (int i=0; i<result.size();i++)
        {
            Bailleur entite = result.get(i).getBailleur();
            bailleurs.add(entite);
        }
        if(bailleurs.isEmpty())
            System.out.println("Il n'existe aucun bailleur pour ce programme");
        else {
            System.out.println("Les noms des bailleurs de ce programme sont :");
            for (int i=0; i<bailleurs.size(); i++) {
                System.out.println(bailleurs.get(i).getNom());
            }
        }
    }

    public void getBailleursByProjetDerby() throws SQLException {
        BaseRepository<Bailleur_has_Projet> instance = new BaseRepository<Bailleur_has_Projet>(puDerby, Bailleur_has_Projet.class);
        Projet projet = new Projet();
        projet.setNom("Vincent");
        List<Bailleur_has_Projet> result = instance.findEntitiesByProperty(projet.getId(), "projet_id");
        List<Bailleur> bailleurs = new LinkedList<Bailleur>() ;
        for (int i=0; i<result.size();i++)
        {
            Bailleur entite = result.get(i).getBailleur();
            bailleurs.add(entite);
        }
        if(bailleurs.isEmpty())
            System.out.println("Il n'existe aucun bailleur pour ce programme");
        else {
            System.out.println("Les noms des bailleurs de ce programme sont :");
            for (int i=0; i<bailleurs.size(); i++) {
                System.out.println(bailleurs.get(i).getNom());
            }
        }
    }
}