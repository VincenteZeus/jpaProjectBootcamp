package com.bootcamp;

import com.bootcamp.jpa.entities.Bailleur;
import com.bootcamp.jpa.enums.TypeDeBailleur;
import com.bootcamp.jpa.repositories.BaseRepository;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BailleurTest extends BaseRepository {

    @Test
    public void createBailleurSql() throws SQLException {
        BaseRepository<Bailleur> bailleur = new BaseRepository<Bailleur>("tpJpa", Bailleur.class);
        Bailleur test = new Bailleur();
        test.setNom("Vincent");
        test.setTypeDeBailleur(TypeDeBailleur.gouvernementale);
         if (bailleur.create(test))
           System.out.println("Création d'un bailleur réussi");
    }

    @Test
    public void findByProgrammeSql() throws SQLException {
        BaseRepository<Bailleur> base = new BaseRepository<Bailleur>("tpJpa", Bailleur.class);
        List <Bailleur> bailleurs = new ArrayList<Bailleur>();
        bailleurs = base.findManyByProperty("Programme", "programme");
        if(bailleurs.isEmpty())
            System.out.println("Aucun bailleur disponible pour ce programme");
        else {
            System.out.println("Les noms des bailleurs disponibles pour ce programme sont :");
            for(int i=0; i<bailleurs.size(); i++) {
                System.out.println(bailleurs.get(i).getNom());
            }
        }
    }

    @Test
    public void findByProjetSql() throws SQLException {
        BaseRepository<Bailleur> base = new BaseRepository<Bailleur>("tpJpa", Bailleur.class);
        List <Bailleur> bailleurs = new ArrayList<Bailleur>();
        bailleurs = base.findManyByProperty("Projet", "projet");
        if(bailleurs.isEmpty())
            System.out.println("Aucun bailleur disponible pour ce projet");
        else {
            System.out.println("Les noms des bailleurs disponibles pour ce projet sont :");
            for(int i=0; i<bailleurs.size(); i++) {
                System.out.println(bailleurs.get(i).getNom());
            }
        }
    }

    
}