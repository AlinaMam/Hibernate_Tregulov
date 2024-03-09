package org.example.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.openSession();
/*
            Section section1 = new Section("football");
            Child child1 = new Child("Zaur", 5);
            Child child2 = new Child("Masha", 7);
            Child child3 = new Child("Vasya", 6);
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();

            session.save(section1);

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");

           /* Section section2 = new Section("vollayball");
            Section section3 = new Section("chess");
            Section section4 = new Section("math");
            Child child = new Child("Grisha", 3);
            child.addSectionToChild(section2);
            child.addSectionToChild(section3);
            child.addSectionToChild(section4);

            session.beginTransaction();

            session.save(child);

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");

            /*session.beginTransaction();

            Section section = session.get(Section.class, 3);
            System.out.println(section);
            System.out.println(section.getChildren());

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");

           /* session.beginTransaction();

            Child child = session.get(Child.class, 7);
            System.out.println(child);
            System.out.println(child.getSections());

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");

           /* session.beginTransaction();

            Section section = session.get(Section.class, 3);
            session.delete(section);

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");
/*

            Section section1 = new Section("basketball");
            Child child1 = new Child("Olya", 12);
            Child child2 = new Child("Egor", 8);
            Child child3 = new Child("Sasha", 9);
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();

            session.persist(section1);

            session.getTransaction().commit();
            System.out.println("Done!");
*/

         /*   session.beginTransaction();

            session.save(section1);
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);
            session.save(child1);
            session.save(child2);
            session.save(child3);

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");

            Section section = session.get(Section.class, 10);
            Child child = session.get(Child.class, 8);

            session.beginTransaction();

            session.delete(child);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
