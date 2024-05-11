import java.util.ArrayList;
import textio.TextIO;

class Student {

    private String name, id, grade;
    private int age;

    public Student(String name, String id, int age, String grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    String getName() {
        return this.name;
    }

    void setName(String name){
        this.name = name;
    }

    String getId() {
        /**Returns the id of the student object*/
        return this.id;
    }

    int getAge() {
        return this.age;
    }

    void setAge(int age) {
        this.age = age;
    }

    String getGrade() {
        return this.grade;
    }

    void setGrade(String grade) {
        this.grade = grade;
    }
}

class StudentManagement {
    private ArrayList<Student> studentList = new ArrayList<>();
    public int numberOfStudents = 0;

    public void addStudent(Student student) {
        // Adds a new student to the list.
        studentList.add(student);
        System.out.println("Student successfully added.\n");
    }
    // Prints details of all students.
    public void viewStudentDetails(String id) {
        System.out.println("\nName\t\t\t\t\tID\t\t\tAge\t\t\tGrade");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        // finding student with the ID

        Student stdnt = findStudent(id);
        System.out.printf("%s\t\t%s\t\t\t%d\t\t\t%s\n", stdnt.getName(), stdnt.getId(), stdnt.getAge(), stdnt.getGrade());
    }

    public void viewAll() {
        System.out.println("\nName\t\t\t\t\tID\t\t\tAge\t\t\tGrade");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        // Printing out the student list
        for(Student student: studentList) {
            System.out.printf("%s\t\t%s\t\t\t%d\t\t\t%s%n", student.getName(), student.getId(), student.getAge(), student.getGrade());
        }
    }

    public void updateStudent(String id) {
        Student student = findStudent(id);
        System.out.println("\nWhat detail do you want to update?");
        System.out.println("""
                1. Name\t\t2. Age
                3. Grade\t4. Exit
                """);
        // receive option from user
        int option = TextIO.getlnInt();
        switch (option) {
            case 1 -> {
                System.out.printf("Update Student Name (Leave blank to keep unchanged)\nName (%s):\t", student.getName());
                String newName = TextIO.getlnString();
                if (!newName.isEmpty()) {
                    student.setName(newName);
                    System.out.println("\nName successfully changed\n");
                }
            }
            case 2 -> {
                System.out.printf("Update Student Age (Leave blank to keep unchanged)\nAge (%d):\t", student.getAge());
                int newAge = TextIO.getlnInt();
                if (newAge >= 0) {
                    student.setAge(newAge);
                    System.out.println("\nAge successfully changed\n");
                }
            }
            case 3 -> {
                System.out.printf("Update Student Grade (Leave blank to keep unchanged)\nGrade (%s):\t", student.getGrade());
                String newGrade = TextIO.getlnString();
                if (!newGrade.isEmpty()) {
                    student.setGrade(newGrade);
                    System.out.println("\nGrade successfully changed\n");
                }
            }
            default -> System.out.println("Invalid option");
        }
    }

    public Student findStudent(String id) {
        // method to find a student from the student list by ID
        for (Student student: studentList){
            if (student.getId().equals(id))
                return student;
        }
        System.out.println("Student ID not found");
        return null;
    }

    public void start() {
        int choice;

        do {
            System.out.println("Welcome to Student Record Management System!");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. View Student List");
            System.out.println("5. Exit");
      
            System.out.print("Enter your choice: ");
            
            choice = TextIO.getlnInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("\nEnter");
                    System.out.print("Name:\t");
                    String name = TextIO.getlnString();
                    System.out.print("ID:\t");
                    String id = TextIO.getlnString();
                    System.out.print("Age:\t");
                    int age = TextIO.getlnInt();
                    System.out.print("Grade:\t");
                    String grade = TextIO.getlnString();
                    Student stdnt = new Student(name, id, age, grade);
                    addStudent(stdnt);
                }
                case 2 -> {
                    System.out.print("Enter Student ID to update: ");
                    String id = TextIO.getln();
                    updateStudent(id);
                }
                case 3 -> {
                    System.out.print("Enter Student ID to view: ");
                    String id = TextIO.getln();
                    viewStudentDetails(id);
                }
                case 4 -> {
                    viewAll();
                }
                case 5 -> {
                    System.out.println("Exiting program!...");
                }
                default -> {
                    System.out.println("Invalid Choice.");
                }
            }
        } while (choice != 5);
    }
}

/**
 * Assignment3
 */
public class Assignment3 {
    public static void main(String[] args) {
        StudentManagement stdntMngmt = new StudentManagement();
        stdntMngmt.start();
    }
}