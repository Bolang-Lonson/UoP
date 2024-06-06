import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    int age;
    String department;
    double salary;

    Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Getters for the employee attributes
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

interface NameAndDepartment {
    String details(Employee employee);
}

class EmployeeProcessor {
    
    public static void main(String[] args) {
        // Sample dataset
        List<Employee> employees = Arrays.asList(
            new Employee("John Doe", 25, "Engineering", 50000),
            new Employee("Jane Smith", 35, "Marketing", 60000),
            new Employee("Mike Johnson", 45, "Sales", 55000),
            new Employee("Emily Davis", 32, "HR", 48000)
        );

        // Function to concatenate name and department
        NameAndDepartment nameAndDepartmentFunction = emp -> emp.getName() + " (" + emp.getDepartment() + ")";

        // Generate a new collection with concatenated strings
        List<String> nameAndDepartmentList = employees.stream()
                .map(employee -> nameAndDepartmentFunction.details(employee))
                .collect(Collectors.toList());

        // Print the name and department list
        System.out.println("Name and Department List: " + nameAndDepartmentList);

        // Calculate the average salary of all employees
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        // Print the average salary
        System.out.println("Average Salary: " + averageSalary);

        // Filter employees whose age is above 30
        List<Employee> filteredEmployees = employees.stream()
                .filter(emp -> emp.getAge() > 30)
                .collect(Collectors.toList());

        // Print the filtered employees
        System.out.println("Filtered Employees (Age > 30):");
        filteredEmployees.forEach(emp -> System.out.println(emp.getName() + ", Age: " + emp.getAge() + ", Department: " + emp.getDepartment() + ", Salary: " + emp.getSalary()));
    }
}