package org.example.oneToOne.OneToOne_uni;

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
            /*Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = new Employee("Zaur", "Tregulov", "IT", 600);
            Details detail = new Details("Baku", "1234567", "tregulov@gmail.com");
            employee.setDetails(detail);

            //мы сохранили только employee, но потому что есть OneToOne relation и мы прописали cascade, то детали тоже
            //сохранятся в таблицу details
            session.save(employee);

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");

            /*Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = new Employee("Oleg", "Mishin", "IT", 700);
            Details detail = new Details("Moscow", "123454567", "mishin@gmail.com");
            employee.setDetails(detail);
            session.save(employee);

            session.getTransaction().commit();
            System.out.println("Done!");
*/

            System.out.println("---");

           /* session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 11);
            System.out.println(employee.getDetails());

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");

            session = factory.getCurrentSession();
            session.beginTransaction();

            //благодаря cascade удалится не только employee но и связанные с ним детали
            Employee employee = session.get(Employee.class, 2);
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
