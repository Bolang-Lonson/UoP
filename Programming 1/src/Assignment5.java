import java.util.ArrayList;
import java.util.HashMap;

public class Assignment5 {

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
        if (course.isFull) {
            System.out.println("Error: Course " + course.getCode() + " is full already");
            return;
        }
        enrolledCourses.add(course);
        course.addStudent();
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
        this.courseCode = code;
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

    public static void addCourse(String code, String name, int maxCapacity) {
        courses.add(new Course(code, name, maxCapacity));
    }

    public static void enrollStudent(Student student, Course course) {
        student.enroll(course);
    }

    public static void assignGrade(Student student, Course course, String grade) {
        student.assignGrade(course, grade);
    }
}