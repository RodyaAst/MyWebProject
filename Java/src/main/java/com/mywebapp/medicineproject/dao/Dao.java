package com.mywebapp.medicineproject.dao;

import com.mywebapp.medicineproject.base.BaseEntity;
import com.mywebapp.medicineproject.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;
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
        return session.createCriteria(clazz).list();
    }

    public <T extends BaseEntity> Optional<T> findById(Class<T> clazz, Long id) {
        var session = getSession();
        return Optional.ofNullable(session.find(clazz, id));
    }

    public <T extends BaseEntity> T add(T entity) {
        var session = getSession();
        session.save(entity);
        return entity;
    }

    public <T extends BaseEntity> void update(T entity) {
        var session = getSession();
        session.merge(entity);
    }

    public <K extends Serializable> void delete(K id) {
        var session = getSession();
        session.delete(id);
        session.flush();
    }


    public Session getSession() {
        return sessionFactory.openSession();
    }
}
