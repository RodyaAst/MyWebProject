package com.example.java.dao;

import com.example.java.base.BaseEntity;
import com.example.java.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Component
public class Dao {

    private final SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    public Dao() {
        this.sessionFactory = HibernateUtil.buildSessionFactory();
    }

    public <T extends BaseEntity> List<T> getAll(Class<T> clazz) {
        var entityList = entityManager.createQuery("from " + clazz.getName()).getResultList();
        return entityList;
    }

    public <T extends BaseEntity> Optional<T> findById(Class<T> clazz, Long id) {
        var maybeEntity = Optional.ofNullable(entityManager.find(clazz, id));
        return maybeEntity;
    }

    public <T extends BaseEntity> T add(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public <T extends BaseEntity> void update(T entity) {
        entityManager.merge(entity);
    }

    public <E extends BaseEntity> void delete(E entity) {
        entityManager.remove(entity);
        entityManager.flush();;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
