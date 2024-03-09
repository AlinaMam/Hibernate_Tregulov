package org.example.crud;

import org.example.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1_insert {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Petr", "Sergeev", "IT", 600);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            System.out.println(emp);
        }
    }
}
