package apps;

import apps.entities.Employee;
import apps.entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {
    private final EntityManager manager;

    public Engine(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        //this.removeObjects();
        //this.containsEmployee();
        //this.employeesWithSalaryOver50000();
        //this.employeesfromDepartment();
        this.addingANewAddressAndUpdatingEmployee();
    }

    private void addingANewAddressAndUpdatingEmployee() {

    }

    private void employeesfromDepartment() {
        this.manager.getTransaction().begin();

        List<Employee> employees = this.manager
                .createQuery("select  e from Employee e where e.department.name = 'Research and Development'" +
                        " order by e.salary, e.id asc ", Employee.class).getResultList();

        employees.forEach(emp -> System.out.printf("%s %s %s - %.2f%n", emp.getFirstName()
                , emp.getLastName(), emp.getDepartment().getName(), emp.getSalary()));

        this.manager.close();
    }

    private void employeesWithSalaryOver50000() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter over salary: ");
        String input = scanner.nextLine();

        this.manager.getTransaction().begin();

        List<Employee> employees = this.manager
                .createQuery("select e from Employee e where e.salary > ?1", Employee.class)
                .setParameter(1, new BigDecimal(input)).getResultList();

        employees.forEach(emp -> System.out.println(emp.getFirstName()));
    }

    private void containsEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first and last name: ");

        String name = scanner.nextLine();

        this.manager.getTransaction().begin();

        /*List<Employee> employees = (List<Employee>) this.manager
                .createQuery("select e from Employee e where concat(e.firstName, ' ', e.lastName) = ?1 ", Employee.class)
                .setParameter(1, name)
                .getSingleResult();

        if (employees.size() == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }*/

        try {
            Employee employee = this.manager
                    .createQuery("select e from Employee e where concat(e.firstName, ' ', e.lastName) = ?1 ", Employee.class)
                    .setParameter(1, name)
                    .getSingleResult();

            System.out.println("Yes");
        }catch (NoResultException nre) {
            System.out.println("No");
        }

        this.manager.getTransaction().commit();
    }

    private void removeObjects() {
        this.manager.getTransaction().begin();

        /*List<Town> towns = this.manager.createQuery("select t from Town t where length(t.name) <= 5 ", Town.class)
                .getResultList();

        for (Town t : towns) {
            System.out.print(t.getName() + " -> ");
            t.setName(t.getName().toLowerCase());
            System.out.println(t.getName());
        }*/

        List<Town> towns = this.manager
                .createQuery("select t from Town t ", Town.class).getResultList();
        for (Town town : towns) {
            if (town.getName().length() > 5) {
                this.manager.detach(town);
            }
        }

        for (Town town : towns) {
            if (this.manager.contains(town)) {
                System.out.print(town.getName() + " -> ");

                town.setName(town.getName().toLowerCase());

                System.out.println(town.getName());
            }
        }

        this.manager.getTransaction().commit();
    }
}
