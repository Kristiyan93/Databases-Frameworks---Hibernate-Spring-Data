package apps;

import apps.entities.Address;
import apps.entities.Employee;
import apps.entities.Project;
import apps.entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.util.Comparator;
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
        //this.addingANewAddressAndUpdatingEmployee();
        //this.addressesWithEmployeeCount();
        //this.getEmployeeWithProject();
        //this.findLatest10Projects();
        //this.increaseSalaries();
        //this.removeTowns();
        //this.findEmployeesByFirstName();
        //this.employeesMaximumSalaries();
    }

    private void employeesMaximumSalaries() {
        this.manager.getTransaction().begin();
        StringBuilder sb = new StringBuilder();

        List<Employee> employees = this.manager
                .createQuery("select e from Employee e " +
                        "WHERE e.salary between 30000 and 70000" +
                        " group by e.department " +
                        "order by e.salary desc ", Employee.class)
                .getResultList();

        employees.
                stream()
                .sorted(Comparator.comparing(e -> e.getDepartment().getId()))
                .forEach(employee -> sb.append(String.format("%s - %.2f%n",
                        employee.getDepartment().getName(), employee.getSalary())));

        System.out.println(sb.toString());

        this.manager.close();
    }

    private void findEmployeesByFirstName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter regex: ");
        String p = scanner.nextLine();

        this.manager
                .createQuery("SELECT e FROM Employee AS e WHERE e.firstName LIKE :p", Employee.class)
                .setParameter("p", p + "%")
                .getResultList()
                .forEach(employee -> System.out.printf("%s %s - %s - ($%.2f)%n", employee.getFirstName(),
                        employee.getLastName(), employee.getJobTitle(), employee.getSalary()));
    }

    private void removeTowns() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.print("Enter town name: ");
        String townName = scanner.nextLine().trim();

        Town town = this.manager .createQuery("SELECT t FROM Town AS t WHERE t.name = :townName", Town.class)
                .setParameter("townName", townName)
                .getSingleResult();

        List<Address> addresses = this.manager
                .createQuery("SELECT a FROM Address AS a WHERE a.town.name = :townName", Address.class)
                .setParameter("townName", townName)
                .getResultList();

        String output = String.format("%d address%s in %s deleted%n",
                addresses.size(), (addresses.size() != 1) ? "es" : "", town.getName());

        this.manager.getTransaction().begin();

        addresses.forEach(address -> {
            for (Employee employee : address.getEmployees()) {
                employee.setAddress(null);
            }
            address.setTown(null);
            this.manager.remove(address);
        });

        this.manager.remove(town);
        this.manager.getTransaction().commit();
        this.manager.close();

        System.out.println(output);
    }

    private void increaseSalaries() {
        this.manager.getTransaction().begin();

        this.manager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services') " +
                        "ORDER BY e.id", Employee.class)
                .getResultList()
                .forEach(employee -> {
                    employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
                    System.out.printf("%s %s($%.2f)%n", employee.getFirstName(),
                            employee.getLastName(), employee.getSalary());
                });

        this.manager.getTransaction().commit();

    }

    private void findLatest10Projects() {
        StringBuilder projects = new StringBuilder();

        this.manager
                .createQuery("SELECT p FROM Project AS p ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> projects
                        .append("Project name: ").append(project.getName()).append(System.lineSeparator())
                        .append("\tProject Description: ").append(project.getDescription()).append(System.lineSeparator())
                        .append("\tProject Start Date: ").append(project.getStartDate()).append(System.lineSeparator())
                        .append("\tProject End Date: ").append(project.getEndDate()).append(System.lineSeparator()));

        System.out.println(projects.toString());
    }

    private void getEmployeeWithProject() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter id: ");
        int id;

        try {
            id = Integer.parseInt(scanner.nextLine());
        }catch (Exception e) {
            System.out.println("Enter Integer -> ");
            id = Integer.parseInt(scanner.nextLine());
        }

        Employee employee = this.manager
                .createQuery("select e from Employee e where e.id = ?1", Employee.class)
                .setParameter(1, id)
                .getSingleResult();

        System.out.printf("%s %s - %s%n", employee.getFirstName()
        , employee.getLastName(), employee.getJobTitle());

        employee.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.println(p.getName()));
    }

    private void addressesWithEmployeeCount() {
        StringBuilder sb = new StringBuilder();

        this.manager
                .createQuery("SELECT a FROM  Address AS a ORDER BY a.employees.size DESC, a.town.id", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(address -> sb.append(String.format("%s, %s - %d employees%n",
                        address.getText(), address.getTown().getName(), address.getEmployees().size())));

        System.out.println(sb.toString());
    }

    private void addingANewAddressAndUpdatingEmployee() {
        Scanner scanner = new Scanner(System.in);

        this.manager.getTransaction().begin();

        Address address = new Address();
        address.setText("Vitoshka 15");

        this.manager.persist(address);

        Town sofia = this.manager
                .createQuery("select t from Town t where t.name = 'Sofia' ", Town.class)
                .getSingleResult();

        address.setTown(sofia);

        System.out.print("Enter last name: ");
        String input = scanner.nextLine();

        Employee employee = this.manager
                .createQuery("select  e from Employee e where e.lastName = ?1", Employee.class)
                .setParameter(1, input)
                .getSingleResult();

        this.manager.persist(address);
        employee.setAddress(address);

        this.manager.getTransaction().commit();
        this.manager.close();
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
