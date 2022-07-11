package com.mywebapp.medicineproject.utils;

import com.mywebapp.medicineproject.entities.*;
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
        configuration.configure();

        return configuration.buildSessionFactory();
    }
}
