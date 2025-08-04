import java.util.ArrayList;
import java.util.List;

// Abstract base class for course types
abstract class CourseType {
    private String title;
    private int credits;

    public CourseType(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public abstract String getEvaluationMethod();

    @Override
    public String toString() {
        return title + " (" + credits + " credits) - " + getEvaluationMethod();
    }
}

// Exam-based course
class ExamCourse extends CourseType {
    public ExamCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public String getEvaluationMethod() {
        return "Exam-Based";
    }
}

// Assignment-based course
class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based";
    }
}

// Research-based course
class ResearchCourse extends CourseType {
    public ResearchCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public String getEvaluationMethod() {
        return "Research-Based";
    }
}

// Generic course class for managing any course type
class Course<T extends CourseType> {
    private T courseDetails;

    public Course(T courseDetails) {
        this.courseDetails = courseDetails;
    }

    public T getCourseDetails() {
        return courseDetails;
    }

    @Override
    public String toString() {
        return courseDetails.toString();
    }
}

// Utility to display a list of any type of courses
class CourseUtils {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }
}

// Main class to run the system
public class UniversityCourseManagement {
    public static void main(String[] args) {
        // Create individual course instances
        Course<ExamCourse> math101 = new Course<>(new ExamCourse("Math 101", 4));
        Course<AssignmentCourse> cs102 = new Course<>(new AssignmentCourse("CS 102", 3));
        Course<ResearchCourse> thesis301 = new Course<>(new ResearchCourse("Thesis 301", 6));

        // Create course lists per type
        List<ExamCourse> examCourses = new ArrayList<>();
        examCourses.add(new ExamCourse("Physics 201", 4));
        examCourses.add(math101.getCourseDetails());

        List<AssignmentCourse> assignmentCourses = new ArrayList<>();
        assignmentCourses.add(new AssignmentCourse("Design Patterns", 3));
        assignmentCourses.add(cs102.getCourseDetails());

        List<ResearchCourse> researchCourses = new ArrayList<>();
        researchCourses.add(new ResearchCourse("AI Research", 5));
        researchCourses.add(thesis301.getCourseDetails());

        // Display all courses using wildcards
        System.out.println("=== Exam Courses ===");
        CourseUtils.displayCourses(examCourses);

        System.out.println("\n=== Assignment Courses ===");
        CourseUtils.displayCourses(assignmentCourses);

        System.out.println("\n=== Research Courses ===");
        CourseUtils.displayCourses(researchCourses);
    }
}
