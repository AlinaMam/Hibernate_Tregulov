package org.example.oneToMany.oneToMany_uni;

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
            session = factory.getCurrentSession();
            session.beginTransaction();

            /*Department department = new Department("HR", 500, 1500);
            Employee emp1 = new Employee("Oleg", "Ivanov", 800);
            Employee emp2 = new Employee("Andrey", "Sidorov", 1000);
            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);
            session.save(department);*/

            System.out.println("---");

            /*Department department = session.get(Department.class, 3);
            System.out.println(department);
            System.out.println(department.getEmps());*/

            System.out.println("---");

            /*Employee employee = session.get(Employee.class, 6);
            System.out.println(employee);*/

            System.out.println("---");

            Department department = session.get(Department.class, 2);

            session.getTransaction().commit();
            System.out.println("Done!");


        } finally {
            session.close();
            factory.close();
        }
    }
}
