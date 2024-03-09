package org.example.test.onetoone_uni;

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

            /*Person person = new Person("Roman", "Sergeev");
            Citizen citizen = new Citizen("Казахстан}", "казах");
            person.setCitizen(citizen);*/

            session.beginTransaction();
//            session.save(person);
            Citizen citizen = session.get(Citizen.class, 1);
            System.out.println(citizen);
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
