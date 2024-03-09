package org.example.test.onetoone_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Citizen.class)
                .buildSessionFactory();


        Session session = null;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();

            Citizen citizen = session.get(Citizen.class, 1);
            citizen.getPerson().setCitizen(null);
            session.delete(citizen);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
