package com.mywebapp.medicineproject;

import com.mywebapp.medicineproject.entities.User;
import com.mywebapp.medicineproject.utils.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class UserControllerTest {


    @Test
    public void findByIdTest() {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        var user = session.find(User.class, 139L);
        Assert.notNull(user.getDocuments(), "dsfsdf");
    }
}
