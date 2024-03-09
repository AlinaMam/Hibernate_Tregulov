package org.example.oneToOne.OneToOne_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Details.class)
                .buildSessionFactory();

        Session session = null;
        try {
            /*session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee1 = new Employee("Artem", "Ivanov", "123456", 500);
            Details details1 = new Details("New York", "3468478", "artem@gmail.com");

            //нужно работнику сохранить детали и детялям сохранить работника
            details1.setEmployee(employee1);
            employee1.setDetails(details1);
            session.save(details1);
            session.save(employee1);

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");

            /*session = factory.getCurrentSession();
            session.beginTransaction();

            Details details = session.get(Details.class, 4);
            System.out.println(details.getEmployee());

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");

           /* session = factory.getCurrentSession();
            session.beginTransaction();

            Details details = session.get(Details.class, 4);
            session.delete(details);

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");

        /*    session = factory.getCurrentSession();
            session.beginTransaction();

            Details details = session.get(Details.class, 1);
            session.delete(details);

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("----");
            //чтобы удалить строку в детях с id, мы должны убедиться в том,
            //что нет работников, на которые на неё ссылаются
            //поэтому для начала надо разорвать связь

            session = factory.getCurrentSession();
            session.beginTransaction();

            Details details = session.get(Details.class, 7);
            details.getEmployee().setDetails(null);
            session.delete(details);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
