import java.util.*;
import textio.TextIO;

/**
 * Class which eventually implements the Administrator interface
  */
public class Assignment5 {
    public static void main(String[] args) {
        CourseManagement.start();
    }
}

/**
 * Student class can be used to create Student objects with various attributes
 * @params: name, id
  */
class Student {
    private String name, id;
    private ArrayList<Course> enrolledCourses;
    private HashMap<Course, String> grades = new HashMap<Course, String>();

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<Course>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void enroll(Course course) {
        if (course.isFull()) {
            System.out.println("Error: Course " + course.getCode() + " is full already");
            return;
        }
        enrolledCourses.add(course);
        course.addStudent();
    }

    public HashMap<Course, String> getGrades() {
        return grades;
    }

    public void assignGrade(Course course, String grade) {
        grades.put(course, grade);
    }
}

class Course {
    private String code, name;
    private int maxCapacity;
    private static int numberEnrolled = 0;

    public Course(String code, String name, int maxCapacity) {
        this.code = code;
        this.name = name;
        this.maxCapacity = maxCapacity;
        numberEnrolled++;
    }

    public static int totNumberEnrolled() {
        return numberEnrolled;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public boolean isFull() {
        return numberEnrolled >= maxCapacity;
    }

    public void addStudent() {
        numberEnrolled++;
    }
}

class CourseManagement {
    private static ArrayList<Course> courses = new ArrayList<Course>();
    private static HashMap<Student, HashMap<Course, String>> studentGrades = new HashMap<>();

    public static void addCourse(String code, String name, int maxCapacity) {
        courses.add(new Course(code, name, maxCapacity));
    }

    public static void enrollStudent(Student student, Course course) {
        student.enroll(course);
    }

    public static void assignGrade(Student student, Course course, String grade) {
        student.assignGrade(course, grade);
    }

    public static String calcOverallGrade(Student student) {
        HashMap<Course, String> grades = student.getGrades();
        for (String grade: grades.values()) {
            // implement averaging logic for grades here.
            // grading system not explicitly given or known
        }
    }

    public static String overallCourseGrade(String courseCode) {
        for(Course course: courses) {
            if (course.getCode().equals(courseCode)) {
                for(HashMap<Course, String> courseAndGrade: studentGrades.values()){
                    String grade = courseAndGrade.get(course);
                    // logic to get overall course grade
                }
            }
        }
    }

    public static void start(){
        int option;

        do {
            System.out.println("Course Enrollment and Grade Management System");
            System.out.println("1.\tAdd New Course\n2.\tEnroll Student\n3.\tAssign Grades\n4.\tCalculate Overall Grades\n5.\tExit");

            System.out.print("Enter you option");

            // using TextIO's in-built error handling system
            option = TextIO.getlnInt();
            switch (option) {
                case 1 -> {
                    System.out.println("Enter course");
                    System.out.print("Code:\t");
                    String code = TextIO.getln();
                    System.out.print("Name:\t");
                    String name = TextIO.getln();
                    System.out.print("Maximum Capacity:\t");
                    int maxCapacity = TextIO.getInt();
                    System.out.println();
                    addCourse(code, name, maxCapacity);
                }
                case 2 -> {
                    System.out.println("Enter student's");
                    System.out.print("Name:\t");
                    String name = TextIO.getln();
                    System.out.print("Id:\t");
                    String id = TextIO.getln();
                    
                    System.out.println("Enter course code:");
                    String code = TextIO.getln();
                    for(Course course: courses) {
                        if (course.getCode().equals(code)) {
                            enrollStudent(new Student(name, id), course);
                            break;
                        }
                    }
                    System.out.println("Error: Course doesn't exist in course registry");
                }
                case 3 -> {
                    System.out.println("Enter student's");
                    System.out.print("Name:\t");
                    String name = TextIO.getln();
                    System.out.print("Id:\t");
                    String id = TextIO.getln();

                    System.out.println("Enter course code:");
                    String code = TextIO.getln();
                    for(Course course: courses) {
                        if (course.getCode().equals(code)) {
                            System.out.print("Grade:\t");
                            String grade = TextIO.getln();
                            assignGrade(new Student(name, id), course, grade);
                            break;
                        }
                    }
                    System.out.println("Error: Course doesn't exist in course registry");
                }
                case 4 -> {
                    System.out.println("Enter course code for course:");
                    String code = TextIO.getln();
                    System.out.println("Overall course grade is: " + overallCourseGrade(code));
                }
                case 5 -> {
                    System.out.println("Exiting program!...");
                }
                default -> {
                    System.out.println("Invalid Choice.");
                }
            }
        } while (option != 5);
    }
}