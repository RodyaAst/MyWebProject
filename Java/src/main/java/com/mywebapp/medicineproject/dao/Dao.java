package com.mywebapp.medicineproject.dao;

import com.mywebapp.medicineproject.base.BaseEntity;
import com.mywebapp.medicineproject.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Dao {

    private final SessionFactory sessionFactory;

    public Dao() {
        this.sessionFactory = HibernateUtil.buildSessionFactory();
    }

    public <T extends BaseEntity> T byId(Class<T> clazz, Long id) {
        return getSession().get(clazz, id);
    }

    public <T extends BaseEntity> void add(T entity) {
        var session = getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public <T extends BaseEntity> void delete(T entity) {
        var session = getSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    public <T extends BaseEntity> List<T> getAll(Class<T> clazz) {
        return getSession().createCriteria(clazz).list();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
