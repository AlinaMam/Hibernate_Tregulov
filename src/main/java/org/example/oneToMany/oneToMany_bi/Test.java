package org.example.oneToMany.oneToMany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            /*session = factory.getCurrentSession();
            session.beginTransaction();

            Department department = new Department("IT", 300, 1200);
            Employee emp1 = new Employee("Zaur", "Tregulov", 800);
            Employee emp2 = new Employee("Elena", "Smirnova", 1000);

            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);

            session.save(department);

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");

            /*session = factory.getCurrentSession();
            session.beginTransaction();

            Department department = session.get(Department.class, 1);
            System.out.println(department);
            System.out.println(department.getEmps());

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");

            /*session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee.getDepartment());

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");

            /*session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            //удаление работаника, потянет за собой удаление департамента,  удаление департамента потянуло
            //за собой удаление работников тоже всех
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done!");*/

            System.out.println("---");

            session = factory.getCurrentSession();
            session.beginTransaction();

            //чтобы при удалении департамента не удалялись сотрудники убираем cascade.all
            Employee employee = session.get(Employee.class, 3);
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
