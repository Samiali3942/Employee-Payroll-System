import java.util.ArrayList;
import java.util.List;
import java.util.*;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private List<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("John Smith", 101, 45000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Emily Johnson", 102, 30, 15.0);
        FullTimeEmployee emp3 = new FullTimeEmployee("William Brown", 103, 60000.0);
        PartTimeEmployee emp4 = new PartTimeEmployee("Olivia Davis", 104, 40, 25.0);
        FullTimeEmployee emp5 = new FullTimeEmployee("James Miller", 105, 50000.0);
        PartTimeEmployee emp6 = new PartTimeEmployee("Sophia Wilson", 106, 60, 25.0);
        FullTimeEmployee emp7 = new FullTimeEmployee("Benjamin Taylor", 107, 40000.0);
        PartTimeEmployee emp8 = new PartTimeEmployee("Charlotte Anderson", 108, 20, 15.0);
        FullTimeEmployee emp9 = new FullTimeEmployee("Daniel Thomas", 109, 55000.0);
        PartTimeEmployee emp10 = new PartTimeEmployee("Abigail Moore", 110, 30, 35.0);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);
        payrollSystem.addEmployee(emp5);
        payrollSystem.addEmployee(emp6);
        payrollSystem.addEmployee(emp7);
        payrollSystem.addEmployee(emp8);
        payrollSystem.addEmployee(emp9);
        payrollSystem.addEmployee(emp10);

        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        payrollSystem.removeEmployee(101);
        payrollSystem.removeEmployee(103);
        payrollSystem.removeEmployee(110);
        payrollSystem.removeEmployee(108);

        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployees();
    }
}
