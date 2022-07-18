package com.example.java.dao;

import com.example.java.base.BaseEntity;
import com.example.java.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Dao {

    private final SessionFactory sessionFactory;

    public Dao() {
        this.sessionFactory = HibernateUtil.buildSessionFactory();
    }

    public <T extends BaseEntity> List<T> getAll(Class<T> clazz) {
        var session = getSession();
        session.beginTransaction();
        var entityList = session.createCriteria(clazz).list();
        session.getTransaction().commit();
        return entityList;
    }

    public <T extends BaseEntity> Optional<T> findById(Class<T> clazz, Long id) {
        var session = getSession();
        session.beginTransaction();
        var maybeEntity = Optional.ofNullable(session.find(clazz, id));
        session.getTransaction().commit();
        return maybeEntity;
    }

    public <T extends BaseEntity> T add(T entity) {
        var session = getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        return entity;
    }

    public <T extends BaseEntity> void update(T entity) {
        var session = getSession();
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
    }

    public <E extends BaseEntity> void delete(E entity) {
        var session = getSession();
        session.beginTransaction();
        session.delete(entity);
        session.flush();
        session.getTransaction().commit();
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
