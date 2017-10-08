package com.bootcamp.jpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class BaseRepository<T> {

    private EntityManager em;
    private String unitPersistence;
    private EntityManagerFactory emf;
    private Class entityClass;

    public BaseRepository() {
    }

    public BaseRepository(String unitPersistence, Class entityClass) {
        this.unitPersistence = unitPersistence;
        emf = Persistence.createEntityManagerFactory(this.unitPersistence);
        em = emf.createEntityManager();
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(getUnitPersistence());
        setEm(emf.createEntityManager());
        return getEm();
    }

    public boolean create(T obj) throws SQLException {
        em.persist(obj);
        return true;
    }

    public boolean delete(T obj) throws SQLException {
        em.remove(obj);
        return true;
    }

    public boolean update(T obj) throws SQLException {
        em.merge(obj);
        return true;
    }

    public T findOneByProperty(String propertyName, Object value) throws SQLException {
        String className = entityClass.getClass().getSimpleName();
        String query = "select t from " + className + " t where t." + propertyName + "=:param";
        Query qry = getEm().createQuery(query);
        qry.setParameter("param", value);
        return (T) qry.getSingleResult();
    }

    public List<T> findEntitiesByProperty(Long propertyId, Object value) throws SQLException {
        String className = entityClass.getClass().getSimpleName();
        String query = "SELECT b FROM " + className + " b where b." +propertyId +"=:param";
        Query qry = getEm().createQuery(query);
        qry.setParameter("param", value);
        List<T> listeEntities = qry.getResultList();
        return listeEntities;
    }

    public List<T> findAll() throws SQLException {
        String className = entityClass.getClass().getSimpleName();
        String qlString = "SELECT b FROM " + className + " b";
        Query q = getEm().createQuery(qlString);
        List<T> listeEntities = q.getResultList();
        return listeEntities;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public String getUnitPersistence() {
        return unitPersistence;
    }

    public void setUnitPersistence(String UnitPersistence) {
        this.unitPersistence = UnitPersistence;
    }

    public Class getEntityClass() {
        return entityClass;
    }
}
