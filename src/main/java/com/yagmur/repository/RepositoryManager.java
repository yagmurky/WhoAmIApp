package com.yagmur.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class RepositoryManager <T, ID> implements IRepository<T, ID> {

    private final EntityManagerFactory emf;
    private EntityManager em;
    private final T t;

    public RepositoryManager(T t){
        emf = Persistence.createEntityManagerFactory("CRM");
        em = emf.createEntityManager();
        this.t = t;
    }

    private void openSession(){
        if (!em.getTransaction().isActive()) {
            em = emf.createEntityManager();
            em.getTransaction().begin();
        }
    }


    private void closeSession(){
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public T save(T entity) {
        try {
            openSession();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception exception) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw exception; // Hata durumunu tekrar fırlat
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        return entity;
    }


    @Override
    public Optional<T> findById(ID id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"),id));
        T t1;
        try{
            t1 =  em.createQuery(criteriaQuery).getSingleResult();
            return Optional.of(t1);
        }catch (NoResultException exception){
            return Optional.empty();
        }
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass()); // select * from tblsecmen where id=? ->
        Root<T> root = (Root<T>) criteriaQuery.from(t.getClass());
        criteriaQuery.select(root);
        return em.createQuery(criteriaQuery).getResultList();
    }

}
