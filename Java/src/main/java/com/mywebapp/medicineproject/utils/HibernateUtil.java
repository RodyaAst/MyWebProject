package com.mywebapp.medicineproject.utils;

import com.mywebapp.medicineproject.entities.User;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtil {

    public static SessionFactory buildSessionFactory() {
        var configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.configure();

        return configuration.buildSessionFactory();
    }
}
