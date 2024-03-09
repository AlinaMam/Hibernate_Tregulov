package org.example.test.onetomany_bi;

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

            Citizen citizen = new Citizen("Mongolia", "mongol");
            Person person1 = new Person("Misha", "Mishin");
//            Person person2 = new Person("Petya", "Petushkov");
            citizen.addToPersons(person1);
            person1.setCitizen(citizen);
//            citizen.addToPersons(person2);

            session.save(citizen);

           /* Citizen citizen = session.get(Citizen.class, 2);
            session.delete(citizen);*/

//            Citizen citizen = session.get(Citizen.class, 1);
//            System.out.println(citizen);
//            Person person = session.get(Person.class, 1);
//            System.out.println(person);


            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
