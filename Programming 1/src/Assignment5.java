import java.util.ArrayList;

public class Assignment5 {

}

/**
 * Student class can be used to create Student objects with various attributes
 * @params: name, id
  */
class Student {
    private String name, id;
    private ArrayList<String> enrolledCourses = new ArrayList<String>();

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setId(String newId) {
        id = newId;
    }

    public void addCourse(String course) {
        enrolledCourses.add(course);
    }

    public void deleteCourse(String course) {
        for(String foundCourse: enrolledCourses) {
            if (foundCourse.equals(course)) {
                enrolledCourses.remove(foundCourse);
                return;
            }
        }
        System.out.println("Student is not enrolled in that course");
    }
}

class Course {

}

class CourseManagement {

}