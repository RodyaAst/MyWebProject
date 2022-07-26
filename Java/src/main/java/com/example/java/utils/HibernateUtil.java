package com.example.java.utils;

import com.example.java.auth.entity.PersonAuth;
import com.example.java.entities.*;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtil {

    public static SessionFactory buildSessionFactory() {
        var configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Job.class);
        configuration.addAnnotatedClass(Document.class);
        configuration.addAnnotatedClass(Drug.class);
        configuration.addAnnotatedClass(MedicalCard.class);
        configuration.addAnnotatedClass(PersonAuth.class);
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(PersonAdditionalInfo.class);
        configuration.addAnnotatedClass(PersonAdditionalWeight.class);
        configuration.addAnnotatedClass(PersonAdditionalPressure.class);
        configuration.addAnnotatedClass(PersonBodyInfo.class);
        configuration.configure();

        return configuration.buildSessionFactory();
    }
}
