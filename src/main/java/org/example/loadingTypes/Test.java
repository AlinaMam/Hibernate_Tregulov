package org.example.loadingTypes;

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

            /*Department department = new Department("Sails", 800, 1500);
            Employee emp1 = new Employee("Zaur", "Tregulov", 800);
            Employee emp2 = new Employee("Elena", "Smirnova", 1500);
            Employee emp3 = new Employee("Anton", "Sidorov", 1200);

            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);
            department.addEmployeeToDepartment(emp3);

            session.save(department);*/

            System.out.println("---");

            System.out.println("Get department");
            Department department = session.get(Department.class, 5);
            System.out.println("Show department");
            System.out.println(department);
            /*System.out.println("Show employees of the department");
            System.out.println(department.getEmps());*/
            department.getEmps().get(0);

            session.getTransaction().commit();

            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
